<#macro page_header title='' css='' js='' selected='' subselected = "">
<!DOCTYPE html>
<html lang="en">
<head>
    <title>爱客仕营销平台</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="爱客仕营销平台">
    <link href="https://xpos-file.b0.upaiyun.com/intro/static/css/img/icon_16x16.ico" rel="icon" type="image/x-icon" />
    <link href="https://xpos-file.b0.upaiyun.com/intro/static/css/img/icon_16x16.ico" rel="shortcut icon" type="image/x-icon" />
    <link href="${(static_base)!''}/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <link href="${(static_base)!''}/bootstrap/3.3.5/css/font-awesome.min.css" rel="stylesheet">
    <link href="${(static_base)!''}/market/css/charisma-app.css" rel="stylesheet">
    <link type="text/css" href="${(static_base)!''}/market/css/admin_frame.css" rel="stylesheet" media="screen" />
    <link rel="stylesheet" href="${(static_base)!''}/market/css/base_invite.css">
    <link rel="stylesheet" href="${(static_base)!''}/market/css/colorbox.css">
    <#--check样式-->
    <link href="${(static_base)}/bootstrap/3.3.5/css/blue.css" rel="stylesheet">
    <#if css?length gt 0>
        <#list css?split("|") as c>
    <link rel="stylesheet" type="text/css" href="${static_base}/market/css/${c}.css">
        </#list>
    </#if>
    <#-- jQuery -->
    <script src="${(static_base)}/jquery/1.11.3/jquery.min.js"></script>
    <script src="${(static_base)}/jquery/jquery.form.min.js"></script>

    <#-- external javascript -->
    <script src="${(static_base)!}/market/js/bootstrap.min.js"></script>
    <script src="${(static_base)!}/market/js/jquery.uploadify-3.1.min.js"></script>
    <script src="${(static_base)!}/market/js/charisma.js"></script>

    <#--删除确认-->
    <script src="${(static_base)}/bootstrap/3.3.5/js/bootbox.js"></script>
    <script src="${(static_base)}/bootstrap/3.3.5/js/icheck.min.js"></script>
    <script src="${(static_base)!}/market/js/form/form_template.js"></script>
    <script src="${(static_base)!}/market/js/jquery.dataTables.min.js"></script>
    <script src="${(static_base)!}/market/js/base_invite.js"></script>
    <#if js?length gt 0>
        <#list js?split("|") as j>
    <script src="${static_base}/market/js/${j}.js"></script>
        </#list>
    </#if>
    <script>
        var base = '${(base)!""}',
            static_base = '${static_base!""}';
        $(function(){
            <#if status == 'success'>
                popHint({success:'${(msg)!'成功'}'});
            </#if>
            <#if status == 'failed'>
                popHint({failure:'${(msg)!'失败'}'});
            </#if>
        })
    </script>
</head>
<body>
<div class="alert alert-success invite-alert-success" style="display: none;">成功</div>
<div class="alert alert-danger invite-alert-danger" style="display: none;">失败</div>

<#-- topbar starts -->
<div class="nav-top">

    <div class="navbar-inner">
        <span class="logo fl">营销平台</span>
        <div class="btn-group pull-right">
            <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                <i class="glyphicon glyphicon-user"></i><span class="hidden-sm hidden-xs"> ${(USER_SESSION_KEY.sysAccountVO.username)!''}</span>
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu">
                <li><a href="${(base)!''}/logout">退出</a></li>
            </ul>
        </div>
    </div>
</div>
<!-- topbar ends -->
<div class="ch-container">

<div class="row">

<#--
超小屏幕 手机 (<768px)	小屏幕 平板 (≥768px)	中等屏幕 桌面显示器 (≥992px)	大屏幕 大桌面显示器 (≥1200px)
类前缀	.col-xs-	   .col-sm-	                     .col-md-	        .col-lg-
-->
    <div class=" col-xs-3 col-sm-3 col-md-3 col-lg-2" style="width: 191px;padding-right: 25px">
        <div class="sidebar-nav">
        <#-- 左测菜单栏异步加载 -->
            <div class="nav-canvas">
                <ul class="nav nav-pills nav-stacked main-menu">
                    <li class="nav-header" style="height: 18px;"></li>
                    <@shiro.hasPermission name="invite:view">
                        <li class="<#if selected=='invite'>active</#if>">
                            <a class="" href="${base!''}/invite/list"><i class="glyphicon glyphicon-home"></i>
                                <span>活动</span>
                            </a>
                        </li>
                    </@shiro.hasPermission>
                    <@shiro.hasPermission name="merchant_social:view">
                        <li class="<#if selected=='merchant_social'>active</#if>">
                            <a class="" href="${base!''}/merchant_social/list"><i class="fa fa-globe"></i><span> 商户社交</span></a>
                        </li>
                    </@shiro.hasPermission>
                    <@shiro.hasAnyPermissions name="cover:view,cover_template:view">
                        <li class="accordion <#if selected=='cover'>active</#if>">
                            <a class="" href="#"><i class="glyphicon glyphicon-tasks"></i><span> 封面管理</span></a>
                            <ul class="nav nav-pills nav-stacked" <#if selected='cover'>style="display: block"</#if>>
                                <@shiro.hasPermission name="cover_template:view">
                                    <li class="<#if subselected=='cover_template'>setting</#if>"><a href="${base!''}/cover/template/list">封面模版</a></li>
                                </@shiro.hasPermission>
                                <@shiro.hasPermission name="cover:view">
                                <li class="<#if subselected=='cover_list'>setting</#if>"><a href="${base!''}/cover/list">封面列表</a></li>
                                </@shiro.hasPermission>
                            </ul>
                        </li>
                    </@shiro.hasAnyPermissions>
                    <@shiro.hasPermission name="wx_card:view">
                    <li class="accordion <#if selected=='wx_card'>active</#if>">
                        <a class="" href="#"><i class="fa fa-credit-card"></i><span> 微信卡券</span></a>
                        <ul class="nav nav-pills nav-stacked" <#if selected='wx_card'>style="display: block"</#if>>
                            <@shiro.hasPermission name="wx_card:view">
                            <li class="<#if subselected=='wx_appid'>setting</#if>"><a href="${base!''}/business/wxconfigure/self/list">公众号</a></li>
                            </@shiro.hasPermission>
                            <#--<li class="<#if subselected=='wx_business'>setting</#if>"><a href="${base!''}/business/wxconfigure/wxauthorizer/list">商户</a></li>-->
                            <li class="<#if subselected=='wx_card_list'>setting</#if>"><a href="${base!''}/wx_card/list">微信卡券</a></li>
                        </ul>
                    </li>
                    </@shiro.hasPermission>
                    <@shiro.hasPermission name="business_info:view">
                        <li class="accordion <#if selected=='businessInfo'>active</#if>">
                            <a class="" href="${base!''}/business_info/list"><i class="fa fa-1x fa-info"></i><span> 商户</span></a>
                            <ul class="nav nav-pills nav-stacked" <#if selected='businessInfo'>style="display: block"</#if>>
                                <li class="<#if subselected=='businessInfo'>setting</#if>"><a href="${base!''}/business_info/list">商户</a></li>
                            </ul>
                        </li>
                    </@shiro.hasPermission>
                    <@shiro.hasPermission name="wxPaymentTransaction:view">
                        <li class="accordion <#if selected=='wx_pay'>active</#if>">
                            <a class="" href="#"><i class="fa fa-1x fa-wechat"></i><span> 支付</span></a>
                            <ul class="nav nav-pills nav-stacked" <#if selected='wx_pay'>style="display: block"</#if>>
                                <li class="<#if subselected=='wx_pay_statistics'>setting</#if>"><a href="${base!''}/wxPaymentTransaction/list?tradeState=SUCCESS">微信支付统计</a></li>
                            </ul>
                        </li>
                    </@shiro.hasPermission>
                    <@shiro.hasPermission name="sms:view">
                        <@shiro.lacksRole name="MERCHANT_SOCIAL_MANAGER">
                        <li class="<#if selected=='sms_list'>active</#if>">
                            <a class="" href="${base!''}/sms/sent/list">
                                <i class="glyphicon glyphicon-envelope"></i>
                                <span> 推广管理</span>
                            </a>
                        </li>
                        </@shiro.lacksRole>
                    </@shiro.hasPermission>
                    <li class="accordion <#if selected=='setting'>active</#if>">
                        <a class="" href="#"><i class="glyphicon glyphicon-cog"></i><span> 设置</span></a>
                        <ul class="nav nav-pills nav-stacked" <#if selected='setting'>style="display: block"</#if>>
                            <@shiro.hasPermission name="account:view"><li class="<#if subselected=='account_list'>setting</#if>"><a href="${base!''}/account/list">账号管理</a></li></@shiro.hasPermission>
                            <@shiro.hasPermission name="role:view"><li class="<#if subselected=='role_setting'>setting</#if>"><a href="${base!''}/role">角色管理</a></li></@shiro.hasPermission>
                            <@shiro.hasPermission name="resource:view"><li class="<#if subselected=='resource_setting'>setting</#if>"><a href="${base!''}/resource">资源管理</a></li></@shiro.hasPermission>
                            <li class="<#if subselected=='changePassword'>setting</#if>"><a href="${base!''}/account/changePassword">修改密码</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</#macro>
<#-- 页脚 -->
<#macro page_footer js=''>
</div><!--row ends -->
</div><!--ch-container ends-->
</body>
</html>
</#macro>
<#-- 分页逐渐 -->
<#macro p page totalpage>
    <@compress single_line=true>
        <#if (request.queryString)??>
            <#assign requestParams=request.queryString?replace("\\&?p=(\\d+)\\&?","","r") />
            <#if requestParams?has_content>
                <#assign requestParams = '&' + requestParams />
            </#if>
        </#if>
        <#assign currentPage=page?number >
        <#if currentPage-4 gt 0>
            <#assign beginPage = currentPage-4 />
        <#else>
            <#assign beginPage = 1 />
        </#if>
        <#if totalpage-currentPage lt 4>
            <#assign beginPage = beginPage - (4-totalpage + currentPage)  />
            <#if beginPage lt 1>
                <#assign beginPage = 1 />
            </#if>
        </#if>
        <#if currentPage-1 gt 0>
        <a class="page_a page_prev" href="?p=${currentPage-1}${requestParams}"></a>
        <#else>
        <span class="page_a page_prev" class="disabled"></span>
        </#if>
        <#if currentPage gt 5 && totalpage gt 10 >
        <a class="page_a" href="?p=1${requestParams}">1</a> <span class="page_dots">...</span>
        </#if>
        <#assign endPage=beginPage+8 />
        <#if endPage gt totalpage>
            <#assign endPage=totalpage />
            <#assign beginPage=endPage-8 />
        </#if>
        <#if beginPage lt 1>
            <#assign beginPage = 1 />
        </#if>
        <#if endPage lt 1>
            <#assign endPage = 1 />
        </#if>
        <#list beginPage..endPage as x>
            <#if x == currentPage>
            <span class="current page_a page_a_now">${x}</span>
            <#else>
            <a class="page_a" href="?p=${x}${requestParams}">${x}</a>
            </#if>
        </#list>
        <#if currentPage lte totalpage - 5 && totalpage gt 10>
        <span class="page_dots">...</span> <a href="?p=${totalpage}${requestParams}" class="page_a">${totalpage}</a>
        </#if>
        <#if currentPage lt totalpage>
        <a class="page_a page_next" href="?p=${currentPage+1}${requestParams}"></a>
        <#else>
        <span class="disabled page_a page_next"></span>
        </#if>
    </@compress>
</#macro>

<#macro page_invite_bread active=''>
<nav class="main-navigation">
    <div class="collapse navbar-collapse" id="main-menu">
        <ul class="menu">
            <li class="<#if active == 'invite_detail'>nav-current</#if>" role="presentation">
                <a  href="${base}/${inviteType}/${electronicInviteNumber!'0'}/detail" >活动资料</a>
            </li>
            <#list metaSet as meta>
                <#if 'ecouponinfo'== meta>
                    <@shiro.hasPermission name='ecouponinfo'>
                    <li role="presentation" <#if active == 'ecouponinfo'>class="nav-current"</#if>>
                        <a  href="${base}/ecouponinfo/${electronicInviteNumber!'0'}/list">电子券</a>
                    </li>
                    </@shiro.hasPermission>
                <#elseif 'position'== meta>
                    <li <#if active == 'position'>class="nav-current"</#if>>
                            <a  href="${base}/position/${electronicInviteNumber!'0'}">地图导航</a>
                    </li>
                <#elseif 'wechat_share'== meta>
                    <li <#if active == 'wechat_share'>class="nav-current"</#if>>
                            <a   href="${base}/wxconfig/${electronicInviteNumber!'0'}">微信分享</a>
                    </li>
                <#elseif 'form_template'== meta>
                    <li <#if active == 'form_template'>class="nav-current"<#elseif active == 'form_submission'>class="nav-current"</#if>>
                        <#assign formTemplateRole = false />
                        <@shiro.hasPermission name="form:template">
                            <#assign formTemplateRole = true />
                            <a href="${base}/form/${electronicInviteNumber!'0'}/templateAttribute/list">表单管理</a>
                        </@shiro.hasPermission>
                        <#if formTemplateRole == false>
                            <@shiro.hasPermission name="form:submission">
                                <a href="${base}/form/${electronicInviteNumber!'0'}/formSubmission/list">表单管理</a>
                            </@shiro.hasPermission>
                        </#if>
                    </li>
                <#elseif 'appp_romotion'== meta>
                    <li <#if active == 'appp_romotion'>class="nav-current"</#if>>
                        <a   href="${base}/app_promotion/${electronicInviteNumber!'0'}/list">APP推广</a>
                    </li>
                <#elseif 'guest'== meta>
                    <@shiro.hasPermission name='guest:view'>
                        <li role="presentation" <#if active == 'guest'>class="nav-current"</#if>>
                            <a href="${base}/guest/${electronicInviteNumber!'0'}/list?isValid=1">活动名单</a>
                        </li>
                    </@shiro.hasPermission>
                    <@shiro.hasPermission name='sms:view'>
                        <li role="presentation" <#if active == 'sms_list'>class="nav-current"</#if>>
                            <a href="${base}/sms/${electronicInviteNumber!'0'}/sent/list">短信列表</a>
                        </li>
                    </@shiro.hasPermission>
                    <@shiro.hasPermission name='sms:view'>
                        <li role="presentation" <#if active == 'smsTransaction_list'>class="nav-current"</#if>>
                            <a href="${base}/sms/transaction/${electronicInviteNumber!'0'}">发送日志</a>
                        </li>
                    </@shiro.hasPermission>
                </#if>
            </#list>
        </ul>
    </div>
</nav>
<#--  活动模块信息  -->

</#macro>

