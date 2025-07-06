out.println("<html><head><title>Page1</title></head>");
out.println("<body bgcolor=MediumSlateBlue>");
String uname = request.getParameter("txtName");
out.println("<h1>Welcome "+uname+"</h1>");
Cookie ck1 = new Cookie("Username", uname);
Cookie ck2 = new Cookie("Visit","1");
Cookie ck3 = new Cookie("Color","Red");
response.addCookie(ck1);
response.addCookie(ck2);
response.addCookie(ck3);
out.println("<h1><a href=Servlet2>Click to Visit Page 2