

HttpSession hs = request.getSession();
if(hs != null)
{
    hs.invalidate();
}
out.println("<h3>You are now logged out....To Re-join, kindly log in again.</h3>");

