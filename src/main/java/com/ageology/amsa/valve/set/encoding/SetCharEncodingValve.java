package com.ageology.amsa.valve.set.encoding;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.valves.ValveBase;

public class SetCharEncodingValve extends ValveBase {

  @Override
  public void invoke(Request request, Response response) throws IOException, ServletException {
    request.setCharacterEncoding(encoding);
    getNext().invoke(request, response);
  }

  public void setEncoding(String encoding) {
    if (encoding != null)
      this.encoding = encoding;
  }

  public String getEncoding() {
    return this.encoding;
  }

  private String encoding = org.apache.commons.lang3.CharEncoding.UTF_8;

}
