/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.54
 * Generated at: 2014-11-30 07:02:02 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.gxkj.common.util.SystemGlobals;
import com.gxkj.taobaoservice.entitys.*;
import com.gxkj.taobaoservice.dto.*;
import com.gxkj.common.util.SystemGlobals;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/pages/admin/../common/easyui-html5.jsp", Long.valueOf(1417330918970L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write(" \r\n");
      out.write(" ");
AdminUser a1= (AdminUser)request.getAttribute(SessionConstant._adminUserFalg);
 String name = a1.getName();
      out.write("\r\n");
      out.write(" <!DOCTYPE html>\r\n");
      out.write("<html lang=\"zh\">\r\n");
      out.write("<head>");
      out.write("\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=EmulateIE8\" content=\"ie=edge\"/>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>系统首页</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/icon/icon.css?3\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/easyui/themes/default/easyui.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/easyui/themes/icon.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/easyui/jquery-1.10.2.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/easyui/jquery.easyui.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/easyui/locale/easyui-lang-zh_CN.js\"></script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\t.mask {  \r\n");
      out.write("            position: absolute; top: 0px; filter: alpha(opacity=60); background-color: #777;\r\n");
      out.write("            z-index: 1002; left: 0px;\r\n");
      out.write("            opacity:0.5; -moz-opacity:0.5;\r\n");
      out.write("        }\r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t function getPageArea() {\r\n");
      out.write("\t\tif (document.compatMode == 'BackCompat') {\r\n");
      out.write("\t\t\treturn {\r\n");
      out.write("\t\t\t\twidth: Math.max(document.body.scrollWidth, document.body.clientWidth),\r\n");
      out.write("\t\t\t\theight: Math.max(document.body.scrollHeight, document.body.clientHeight)\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\treturn {\r\n");
      out.write("\t\t\t\twidth: Math.max(document.documentElement.scrollWidth, document.documentElement.clientWidth),\r\n");
      out.write("\t\t\t\theight: Math.max(document.documentElement.scrollHeight, document.documentElement.clientHeight)\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tjQuery.extend({ \r\n");
      out.write("\t\tshowMask: function(el, msg) {\r\n");
      out.write("\t\t\tif(!el)el =document.body;\r\n");
      out.write("\t\t\tvar _1c3=$(el);\r\n");
      out.write("\t\t\tmsg = msg?msg:\"\";\r\n");
      out.write("\t\t\tif(!_1c3.children(\"div.datagrid-mask\").length){\r\n");
      out.write("\t\t\t\t$(\"<div class=\\\"datagrid-mask\\\" style=\\\"display:block\\\"></div>\").appendTo(_1c3);\r\n");
      out.write("\t\t\t\tvar msg=$(\"<div class=\\\"datagrid-mask-msg\\\" style=\\\"display:block;left:50%\\\"></div>\").html(msg).appendTo(_1c3);\r\n");
      out.write("\t\t\t\tmsg.css(\"marginLeft\",-msg.outerWidth()/2);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}, \r\n");
      out.write("\t\thideMask: function(el){ \r\n");
      out.write("\t\t\tif(!el)el =document.body;\r\n");
      out.write("\t\t   var _1c4=$(el);\r\n");
      out.write("\t\t   \tvar mask = _1c4.children(\"div.datagrid-mask-msg\");\r\n");
      out.write("\t\t   \tif(mask){\r\n");
      out.write("\t\t   \t\t_1c4.children(\"div.datagrid-mask-msg\").remove();\r\n");
      out.write("\t\t\t\t_1c4.children(\"div.datagrid-mask\").remove();\r\n");
      out.write("\t\t   \t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t} \r\n");
      out.write("\t});\r\n");
      out.write("</script>");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("var opTabIndex = -1;\r\n");
      out.write("function menuHandler(item){\r\n");
      out.write("\t\t\tif(\"close\" == item.name){\r\n");
      out.write("\t\t\t\t$('#tt').tabs('close',opTabIndex);\r\n");
      out.write("\t\t\t}else if(\"close all\" == item.name){\r\n");
      out.write("\t\t\t\tvar tabs = $('#tt').tabs('tabs');\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tfor(var i=tabs.length-1;i>=0;i--){\r\n");
      out.write("\t\t\t\t\t$('#tt').tabs('close',i);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}else if(\"close other\" == item.name){\r\n");
      out.write("\t\t\t\tvar tabs = $('#tt').tabs('tabs');\r\n");
      out.write("\t\t\t\tfor(var i=tabs.length-1;i>=0;i--){\r\n");
      out.write("\t\t\t\t\tif(i == opTabIndex) continue;\r\n");
      out.write("\t\t\t\t\t$('#tt').tabs('close',i);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("}\r\n");
      out.write("function onContextMenuFn(e, title,index){\r\n");
      out.write("\t\t\t\t\t \r\n");
      out.write("\t\t\t\t\topTabIndex = -1;\r\n");
      out.write("\t\t\t\t\te.preventDefault();\r\n");
      out.write("\t\t\t\t\tvar tabs = $('#tt').tabs('tabs');\r\n");
      out.write("\t\t\t\t \t$(\"#ci\").show();\r\n");
      out.write("\t\t\t\t \t$(\"#ca\").show();\r\n");
      out.write("\t\t\t\t \t$(\"#co\").show();\r\n");
      out.write("\t\t\t\t\tif(index == 0  ){\r\n");
      out.write("\t\t\t\t\t\tif(tabs.length == 1){\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#co\").hide();\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#ca\").hide();\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\topTabIndex = index;\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t$('#mm').menu('show', {\r\n");
      out.write("\t\t\t\t\t\tleft: e.pageX,\r\n");
      out.write("\t\t\t\t\t\ttop: e.pageY\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("</script>\n");
      out.write("<body class=\"easyui-layout\">\r\n");
      out.write("\t<div data-options=\"region:'north',border:false\" style=\"PADDING-BOTTOM: 5px; PADDING-LEFT: 5px; PADDING-RIGHT: 5px; HEIGHT: auto; PADDING-TOP: 5px\"   class=datagrid-toolbar>\r\n");
      out.write("\t\t<table width=\"100%\">\r\n");
      out.write("\t\t\t<tr width=\"100%\">\r\n");
      out.write("\t\t\t\t<td width=\"50%\">\r\n");
      out.write("\t\t\t\t\t 欢迎您:");
      out.print(name );
      out.write("\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td align=\"right\" width=\"50%\">\r\n");
      out.write("\t\t\t\t\t <a href=\"#\" class=\"easyui-linkbutton\" onclick=\"addTabPanel('userhome')\" data-options=\"plain:true,iconCls:'user_btn'\">个人中心</a>\r\n");
      out.write("\t\t\t\t\t <a href=\"#\" class=\"easyui-linkbutton\" onclick=\"logout()\" data-options=\"plain:true,iconCls:'poweroff_btn'\">退出</a>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</div>\n");
      out.write("\t<div data-options=\"region:'west',split:true,border:true,title:'&nbsp;'\"\" style=\"width:250px;padding:10px;\">\r\n");
      out.write("\t\t<ul class=\"easyui-tree\" data-options=\"\r\n");
      out.write("\t\turl:'");
      out.print(request.getContextPath() );
      out.write("/admin/mymenu?'+new Date().getTime(),\r\n");
      out.write("\t\tmethod:'get',\r\n");
      out.write("\t\tloadFilter:function(data){ return treeloadFilter(data);},\r\n");
      out.write("\t\tanimate:true,\r\n");
      out.write("\t\tonClick:treeClickFn\r\n");
      out.write("\t\t\"></ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div region=\"center\" border=\"false\">\r\n");
      out.write("\t\t\t<div id=\"tt\" class=\"easyui-tabs\" fit=\"true\" border=\"false\" plain=\"true\" \r\n");
      out.write("\t\t\t\tdata-options=\"onContextMenu:onContextMenuFn\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"mm\" class=\"easyui-menu\" data-options=\"onClick:menuHandler\" style=\"width:120px;\">\r\n");
      out.write("\t\t<div data-options=\"name:'close'\" id=\"ci\">关闭</div>\r\n");
      out.write("\t\t<div data-options=\"name:'close all'\" id=\"ca\">全部关闭</div>\r\n");
      out.write("\t\t<div data-options=\"name:'close other'\"  id=\"co\">关闭其他</div>\r\n");
      out.write("\t</div>\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function treeloadFilter(menus ,usecheck){\r\n");
      out.write("\tif(menus.length==0)return menus;\r\n");
      out.write(" \t var mapdata = {};\r\n");
      out.write("\t  //第一次组织树节点内容\r\n");
      out.write("\t  for(var i=0;i<menus.length;i++)\r\n");
      out.write("\t  {\r\n");
      out.write("\t      var node = menus[i];\r\n");
      out.write("\t      var menuname = node['name'];\r\n");
      out.write("\t      var parentNo = node['pid'];\r\n");
      out.write("\t      var aid = node['id'] ;\r\n");
      out.write("\t      \r\n");
      out.write("\t      var path = node['path'];\r\n");
      out.write("\t      var isbutton = node['isbutton'];\r\n");
      out.write("\t      var authorityCode = node[\"btnflag\"];\r\n");
      out.write("\t      \r\n");
      out.write("\t\t  if(isbutton == 1){\r\n");
      out.write("\t\t\t\tcontinue;\r\n");
      out.write("\t\t  }\r\n");
      out.write("\t      mapdata[\"id_\"+aid]= {\r\n");
      out.write("\t    \t\t  id:aid,\r\n");
      out.write("\t    \t\t  text:menuname,\r\n");
      out.write("\t    \t\t  parentNo:parentNo,\r\n");
      out.write("\t    \t\t  state:'closed',\r\n");
      out.write("\t    \t\t  attributes:{\r\n");
      out.write("\t    \t\t  \turl:path,\r\n");
      out.write("\t    \t\t  \tisbutton:isbutton,\r\n");
      out.write("\t    \t\t  \tauthorityCode:authorityCode,\r\n");
      out.write("\t    \t\t  \tparentId:parentNo\r\n");
      out.write("\t    \t\t  }\r\n");
      out.write("\t    };\r\n");
      out.write("\t    \r\n");
      out.write("\t     if(usecheck)\r\n");
      out.write("\t\t {\r\n");
      out.write("\t\t \tmapdata[\"id_\"+aid]['checked']=false;\r\n");
      out.write("\t\t }\r\n");
      out.write("\r\n");
      out.write("\t  }\r\n");
      out.write("  var ret = [];\r\n");
      out.write("  for(var key in mapdata)\r\n");
      out.write("  {\r\n");
      out.write("      var node = mapdata[key];\r\n");
      out.write("      var pid = mapdata[key]['parentNo'];\r\n");
      out.write("      if(mapdata[\"id_\"+pid])\r\n");
      out.write("      {\r\n");
      out.write("          if(typeof mapdata[\"id_\"+pid]['children'] == 'undefined')\r\n");
      out.write("          {\r\n");
      out.write("              mapdata[\"id_\"+pid]['children'] = [];\r\n");
      out.write("          }\r\n");
      out.write("          mapdata[\"id_\"+pid]['children'].push(mapdata[key]);\r\n");
      out.write("      }else\r\n");
      out.write("      {\r\n");
      out.write("          ret.push(mapdata[key]);\r\n");
      out.write("      }\r\n");
      out.write("\r\n");
      out.write("  }\r\n");
      out.write("   for(var key in mapdata)\r\n");
      out.write("  {\r\n");
      out.write("       var node = mapdata[key];\r\n");
      out.write("       if(node['children'] == null){\r\n");
      out.write("       \t\tnode['state'] = 'open';\r\n");
      out.write("       }\r\n");
      out.write("\r\n");
      out.write("  }\r\n");
      out.write("\t\r\n");
      out.write("\tif(ret.length>0){ret[0]['state'] = 'open';} \r\n");
      out.write("  return ret;\r\n");
      out.write("}\r\n");
      out.write("function treeClickFn(node){ \r\n");
      out.write("\t\tvar attributs = node.attributes;\r\n");
      out.write("\t \tvar type = jQuery.type(attributs);\r\n");
      out.write("\t \tif(type == 'undefined'){return;}\r\n");
      out.write("\t \tvar url = attributs.url;\r\n");
      out.write("\t \tif($.trim(url).length == 0)return;\r\n");
      out.write("\t \tvar title = node.text;\r\n");
      out.write("\t \tif ($('#tt').tabs('exists',title)){\r\n");
      out.write("\t\t\t\t\t$('#tt').tabs('select', title);\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\t$('#tt').tabs('add',{\r\n");
      out.write("\t\t\t\t\ttitle:title,\r\n");
      out.write("\t\t\t\t\tclosable:true,\r\n");
      out.write("\t\t\t\t\tcache:false,\r\n");
      out.write("\t\t\t\t\tcontent:'<iframe scrolling=\"yes\" frameborder=\"0\"  src=\"");
      out.print(request.getContextPath() );
      out.write("'+url+'?d='+new  Date().getMilliseconds()+'\" style=\"width:100%;height:100%;\"></iframe>'\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("}\r\n");
      out.write("function addTabPanel(flag){\r\n");
      out.write("\t var node = {};\r\n");
      out.write("\t if(flag == 'userhome'){\r\n");
      out.write("\t \tnode = {\r\n");
      out.write("\t \t\ttext:\"个人中心\",\r\n");
      out.write("\t \t\tattributes:{\r\n");
      out.write("\t \t\t\turl:\"/admin/userhome/index\"\r\n");
      out.write("\t \t\t}\r\n");
      out.write("\t \t}\r\n");
      out.write("\t }\r\n");
      out.write("\t treeClickFn(node);\r\n");
      out.write("}\r\n");
      out.write("function logout(){\r\n");
      out.write("\t$.messager.confirm('系统提示', '您确定要退出该系统吗?', function(r){\r\n");
      out.write("\t\tif (r){\r\n");
      out.write("\t\t\twindow.location = \"");
      out.print(request.getContextPath() );
      out.write("/admin/logout\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
