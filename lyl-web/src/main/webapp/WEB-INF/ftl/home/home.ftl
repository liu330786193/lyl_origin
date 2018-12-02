<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bootstrap 实例 - 标签页（Tab）插件</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style type="text/css">
	.center {  
	    width: auto;  
	    display: table;  
	    margin-left: auto;  
	    margin-right: auto;  
	} 
	#tab1{
		margin:10px;
	}
</style>
<body class="center">

<ul id="myTab" class="nav nav-tabs text-center">
    <li class="active">
        <a href="#tab1" data-toggle="tab">
            采购进货
        </a>
    </li>
    <li><a href="#tab2" data-toggle="tab">进货列表</a></li>
    <li><a href="#tab3" data-toggle="tab">销售出货</a></li>
    <li><a href="#tab4" data-toggle="tab">销售列表</a></li>
    <li><a href="#tab5" data-toggle="tab">添加产品</a></li>
    <li><a href="#tab6" data-toggle="tab">产品列表</a></li>
    <li><a href="#tab7" data-toggle="tab">添加客户</a></li>
    <li><a href="#tab8" data-toggle="tab">出货列表</a></li>
</ul>
<div id="myTabContent" class="tab-content">
    <div class="tab-pane fade in active" id="tab1">
        <form class="form-horizontal" role="form">
		  <div class="form-group">
		    <label for="tradeName" class="col-sm-2 control-label">商品名称</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="tradeName" placeholder="请输入商品名称">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="supplier" class="col-sm-2 control-label">供 货 商</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="supplier" placeholder="请输入供货商">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="count" class="col-sm-2 control-label">数    量</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="count" placeholder="请输入数量">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="price" class="col-sm-2 control-label">价    格</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="price" placeholder="请输入价格">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="summation" class="col-sm-2 control-label">合    计</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="summation">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="paid" class="col-sm-2 control-label">已付金额</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="paid" placeholder="请输入已付金额">
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-default">保存</button>
		    </div>
		  </div>
		</form>
    </div>
    <div class="tab-pane fade" style="font-size: 1px;" id="tab2">
        <div class="table-responsive">
		  <table class="table table-hover">
		    <caption>响应式表格布局</caption>
		    <thead>
		      <tr>
		        <th>产品名称</th>
		        <th>供货商</th>
		        <th>数量</th>
		        <th>价格</th>
		        <th>合计</th>
		        <th>已付</th>
		        <th>欠款</th>
		        <th>合计</th>
		        <th>进货时间</th>
		      </tr>
		    </thead>
		    <tbody>
		      <tr>
		        <td>产品1</td>
		        <td>23/11/2013</td>
		        <td>待发货</td></tr>
		      <tr>
		        <td>产品2</td>
		        <td>10/11/2013</td>
		        <td>发货中</td></tr>
		      <tr>
		        <td>产品3</td>
		        <td>20/10/2013</td>
		        <td>待确认</td></tr>
		      <tr>
		        <td>产品4</td>
		        <td>20/10/2013</td>
		        <td>已退货</td></tr>
		    </tbody>
		  </table>
		</div>
    </div>
    <div class="tab-pane fade" id="tab3">
        <p>jMeter 是一款开源的测试软件。它是 100% 纯 Java 应用程序，用于负载和性能测试。</p>
    </div>
    <div class="tab-pane fade" id="tab4">
        <p>Enterprise Java Beans（EJB）是一个创建高度可扩展性和强大企业级应用程序的开发架构，部署在兼容应用程序服务器（比如 JBOSS、Web Logic 等）的 J2EE 上。
        </p>
    </div>
    <div class="tab-pane fade" id="tab5">
        <p>Enterprise Java Beans（EJB）是一个创建高度可扩展性和强大企业级应用程序的开发架构，部署在兼容应用程序服务器（比如 JBOSS、Web Logic 等）的 J2EE 上。
        </p>
    </div>
    <div class="tab-pane fade" id="tab6">
        <p>Enterprise Java Beans（EJB）是一个创建高度可扩展性和强大企业级应用程序的开发架构，部署在兼容应用程序服务器（比如 JBOSS、Web Logic 等）的 J2EE 上。
        </p>
    </div>
    <div class="tab-pane fade" id="tab7">
        <p>Enterprise Java Beans（EJB）是一个创建高度可扩展性和强大企业级应用程序的开发架构，部署在兼容应用程序服务器（比如 JBOSS、Web Logic 等）的 J2EE 上。
        </p>
    </div>
    <div class="tab-pane fade" id="tab8">
        <p>Enterprise Java Beans（EJB）是一个创建高度可扩展性和强大企业级应用程序的开发架构，部署在兼容应用程序服务器（比如 JBOSS、Web Logic 等）的 J2EE 上。
        </p>
    </div>
</div>

</body>
</html>