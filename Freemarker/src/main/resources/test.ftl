<html>

<head>
    <title>Freemarker</title>
    <meta charset="utf-8"/>
</head>

<body>
<#include "head.ftl">
<#-- 注释内容 -->
欢迎：${name},${message}<br>

<#--使用ftl指令定义变量-->
<#assign linkman="李四"/>
联系人：${linkman}<br>

<#if success=true>
    success为true
<#else>
    success为false
</#if>
<br>
<#--list指令-->
<#list goodsList as goods>
   编号：${goods_index+1} 商品名称:${goods.name}  价格：${goods.price}<br>
</#list>
总共${goodsList?size}条记录<br>

<#assign text="{'name':'zhangsan','age':'15'}">
<#--将字符串转换为对象-->
<#assign data=text?eval>
姓名:${data.name}<br>
年龄:${data.age}<br>

<#--日期显示-->
当前日期：${date?date}<br>
当前时间：${date?time}<br>
当前日期-时间:${date?datetime}<br>
日期格式化:${date?string("yyyy年MM月")}<br>

<#--数字显示-->
当前积分:${point}<br>
数字去掉逗号:${point?c}<br>

<#if aaa??>
    变量a存在
<#else>
    变量a不存在
</#if>

${bbb!'变量b不存在'}
</body>
</html>