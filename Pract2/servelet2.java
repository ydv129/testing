out.println("<html><head><title>Page2</title></head>");
out.println("<body bgcolor=Aquamarine>");
out.println("<h1> Welcome to Page 2 </h1>");
Cookie [] ck = request.getCookies();
for(int i=0;i<ck.length;i++)
{
if(ck[i].getName().equals("Visit"))
{
int count = Integer.parseInt(ck[i].getValue())+1;
out.println("<h1>Visit No : "+count+"</h1>");
ck[i] = new Cookie("Visit",count+"");
//out.println(ck[i].getName()+ck[i].getValue());
response.addCookie(ck[i]);
}
else
{
out.println("<h1>"+ck[i].getName()+ " : "+ck[i].getValue()+"</h1>");
}
}
out.println("<h1><a href=Servlet3>Click to visit Page 3 </a></h1>");