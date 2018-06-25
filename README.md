# tomcat-setencoding-valve
Simple Tomcat valve to set encoding, in case filters are not enough.

## A Tomcat Valve to set the character encoding
This is a valve for setting the charset used for decoding a request for Apache Tomcat servlets. It is similar to Tomcat's [`SetCharacterEncodingFilter`](https://tomcat.apache.org/tomcat-7.0-doc/api/org/apache/catalina/filters/SetCharacterEncodingFilter.html) but, being a valve instead of a filter, it gets executed before all filters. This valve fits into the scenario in which your Tomcat deployment uses other valves that process the request _before_ passing it to filters. In this scenario, the characher encoding of the request is set by the valve that first processes the request and `SetCharacterEncodingFilter` won't do the trick. You can use the valve provided by this package to set your favourite encoding, e.g. UTF-8.

In all other cases, e.g. if you use no valves or your valves do not need to process the request, you should use a [SetCharacterEncodingFilter](https://tomcat.apache.org/tomcat-7.0-doc/api/org/apache/catalina/filters/SetCharacterEncodingFilter.html) to set the encoding.

## How to

1. To compile, do
`mvn jar:jar`

2. Copy the generated jar file (look into `target/`) into your Tomcat deployment `lib` directory.
3. To enable the valve, create a [`context.xml`](https://tomcat.apache.org/tomcat-7.0-doc/config/context.html) in your webapp's `META-INF` directory (if you want to enable it for a single webapp) or edit the global Tomcat `context.xml` adding something like [this](context.xml.example). 
