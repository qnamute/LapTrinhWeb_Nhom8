<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Admin</title>

       <!-- Bootstrap Core CSS -->
        <link href="View/admin/css/bootstrap.min.css" rel="stylesheet">

        <!-- MetisMenu CSS -->
        <link href="View/admin/css/metisMenu.min.css" rel="stylesheet">

        <!-- Timeline CSS -->
        <link href="View/admin/css/timeline.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="View/admin/css/startmin.css" rel="stylesheet">

        <!-- Morris Charts CSS -->
        <link href="View/admin/css/morris.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="View/admin/css/font-awesome.min.css" rel="stylesheet" type="text/css">


        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>

        <div id="wrapper">

            <!-- Navigation -->
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <div class="navbar-header">
                    <a class="navbar-brand" href="index.html">Startmin</a>
                </div>

                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>

                <ul class="nav navbar-nav navbar-left navbar-top-links">
                    <li><a href="#"><i class="fa fa-home fa-fw"></i> Website</a></li>
                </ul>

                <ul class="nav navbar-right navbar-top-links">
                    <li class="dropdown navbar-inverse">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="fa fa-bell fa-fw"></i> <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu dropdown-alerts">
                            <li>
                                <a href="#">
                                    <div>
                                        <i class="fa fa-comment fa-fw"></i> New Comment
                                        <span class="pull-right text-muted small">4 minutes ago</span>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <div>
                                        <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                        <span class="pull-right text-muted small">12 minutes ago</span>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <div>
                                        <i class="fa fa-envelope fa-fw"></i> Message Sent
                                        <span class="pull-right text-muted small">4 minutes ago</span>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <div>
                                        <i class="fa fa-tasks fa-fw"></i> New Task
                                        <span class="pull-right text-muted small">4 minutes ago</span>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <div>
                                        <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                        <span class="pull-right text-muted small">4 minutes ago</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a class="text-center" href="#">
                                    <strong>See All Alerts</strong>
                                    <i class="fa fa-angle-right"></i>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="fa fa-user fa-fw"></i> secondtruth <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                            </li>
                            <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="HomeForward"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <!-- /.navbar-top-links -->

                <div class="navbar-default sidebar" role="navigation">
                    <div class="sidebar-nav navbar-collapse">
                        <ul class="nav" id="side-menu">
                            <li class="sidebar-search">
                                <div class="input-group custom-search-form">
                                    <input type="text" class="form-control" placeholder="Search...">
                                    <span class="input-group-btn">
                                        <button class="btn btn-primary" type="button">
                                            <i class="fa fa-search"></i>
                                        </button>
                                </span>
                                </div>
                                <!-- /input-group -->
                            </li>
                            <li>
                                <a href="index.html" class="active"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                            </li>

                           <li>
                                <a href="DisplayQuestionManager"><i class="fa fa-user fa-fw"></i>Question Manager</a>
                            </li>  
                            
                             <li>
                                <a href="#"><i class="fa fa-user fa-fw"></i>Insert Question From File</a>
                            </li>                        
                          
                            <li>
                                <a href="#"><i class="fa fa-files-o fa-fw"></i> Sample Pages<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="blank.html">Blank Page</a>
                                    </li>
                                    <li>
                                        <a href="login.html">Login Page</a>
                                    </li>
                                </ul>
                                <!-- /.nav-second-level -->
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>

            <div id="page-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">Tables</h1>
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                    <!-- /.row -->
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Classes List
                                </div>
                                <!-- /.panel-heading -->
                                <div class="panel-body">
                                    <div class="table-responsive">
                                        <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                            <thead>
                                                <tr>
                                                    <th>Id</th>
                                                    <th>Type</th>
                                                    <th>Content</th>
                                                    <th>Option 1</th>
                                                    <th>Option 2</th>
                                                    <th>Option 3</th>
                                                    <th>Option 4</th>
                                                    <th>Answer</th>
                                                    <th></th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${questionlist}" var="list">
                                            	    <tr class="odd gradeX">
                                                   		<td>${list.maCauHoi}</td>
                                                        <td>${list.tenLoaiCauHoi}</td>
                                                        <td>${list.noiDung}</td>
                                                        <td>${list.option1}</td>
                                                        <td>${list.option2}</td>
                                                        <td>${list.option3}</td>
                                                        <td>${list.option4}</td>
                                                        <td>${list.dapAnDung}</td>
                                                        <td class="center"><button type="button" class="btn btn-success"  data-toggle="modal" data-target="#modalEdit" onclick="myFunction('${list.maCauHoi}','${list.noiDung}', '${list.option1}', '${list.option2}', '${list.option3}', '${list.option4}')">Edit</button></td>                                                     
                                                        <td class="center"><button type="button" class="btn btn-danger" data-toggle="modal" data-target="#modalConfirmDelete" onclick="myFunctionDelete('${list.maCauHoi}')">Delete</button></td>
                                                   </tr>
                                              </c:forEach>
                                            </tbody>                                              
                                        </table>
                                    </div>
                                    <!-- /.table-responsive -->                                  
                                </div>
                                <!-- /.panel-body -->
                            </div>
                            <!-- /.panel -->
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                     <div class="panel-body">
                     	<div class="table-responsive">
					  		<table class="table table-hover">	
					  			<tr>
					  				<th><p> <button type="button" class="btn btn-warning btn-lg" data-toggle="modal" data-target="#exampleModal">Add new question</button></p></th>
					  				<th><p> <button type="button" class="btn btn-danger btn-lg" data-toggle="modal" data-target="#modalImport">Import question from file</button></p></th>
					  			</tr>
					  		</table>
					  	</div>              	
                     </div>                                       
                </div>
            </div> -->
        </div>
        
        		<!-- Modal Edit -->
		<div class="modal fade" id="modalEdit" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<form action="editQuestion" method="post">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Edit Question !</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">

					  <div class="table-responsive">
					  	<table class="table table-hover">
					  		<thead>
					  			<tr>
					  				<th>#</th>
					  				<th>Input</th>
					  			</tr>
					  		</thead>
					  		<tbody>
					 	 		<tr>
					  				<th>Id</th>	
					  				<th><input class="form-control" name="id2" id="myText1" readonly></th>			  				
					  			</tr>
					  			<tr>
					  				<th>Question type</th>
					  				<th>
					  					<select class="form-control" name="typequestion2">
					  							 <c:forEach items="${typequestion}" var="list">
                                                        <option value = "${list.maLoaiCauHoi}">${list.tenLoaiCauHoi}</option>
                                                 </c:forEach>
                                        </select>
					  				</th>
					  			</tr>
					  			<tr>
					  				<th>Content</th>	
					  				<th><input class="form-control" name="content2" id="myText2"></th>			  				
					  			</tr>
					  			<tr>
					  				<th>Option 1</th>
									<th><input class="form-control" name="option12" id="myText3"></th>
					  			</tr>
					  			<tr>
					  				<th>Option 2</th>
					  				<th><input class="form-control" name="option22" id="myText4"></th>
					  			</tr>
					  			<tr>
					  				<th>Option 3</th>
					  				<th><input class="form-control" name="option32" id="myText5"></th>
					  			</tr>
					  			<tr>
					  				<th>Option 4</th>
					  				<th><input class="form-control" name="option42" id="myText6"></th>
					  			</tr>				
					  			<tr>
					  				<th>Correct</th>
					  				<th>
					  				<select class="form-control" name="correct2">
                                         <option value ="A"> A </option>
                                         <option value ="B"> B </option>
                                         <option value ="C"> C </option>
                                         <option value ="D"> D </option>
                                    </select>
                                    </th>
					  			</tr>					  			
					  		</tbody>
					  	</table>
					  </div>			
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-warning btn-circle btn-xl" data-dismiss="modal"><i class="fa fa-times"></i></button>
		        <button type="submit" class="btn btn-info btn-circle btn-xl"><i class="fa fa-check" data-submit="form"></i></button>
		      </div>
		    </div>
		  </div>
		  </form>
		</div>  
			
		<!-- #modaledit -->
        
        
        <!-- Modal insert -->
        
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<form action="insertQuestion" method="post">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Add new question !</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">

					  <div class="table-responsive">
					  	<table class="table table-hover">
					  		<thead>
					  			<tr>
					  				<th>#</th>
					  				<th>Input</th>
					  			</tr>
					  		</thead>
					  		<tbody>
					  			<tr>
					  				<th>Question type</th>
					  				<th>
					  					<select class="form-control" name="typequestion1">
					  							 <c:forEach items="${typequestion}" var="list">
                                                        <option value = "${list.maLoaiCauHoi}">${list.tenLoaiCauHoi}</option>
                                                 </c:forEach>
                                        </select>
					  				</th>
					  			</tr>
					  			<tr>
					  				<th>Content</th>	
					  				<th><input class="form-control" name="content1"></th>			  				
					  			</tr>
					  			<tr>
					  				<th>Option 1</th>
									<th><input class="form-control" name="option11"></th>
					  			</tr>
					  			<tr>
					  				<th>Option 2</th>
					  				<th><input class="form-control" name="option21"></th>
					  			</tr>
					  			<tr>
					  				<th>Option 3</th>
					  				<th><input class="form-control" name="option31"></th>
					  			</tr>
					  			<tr>
					  				<th>Option 4</th>
					  				<th><input class="form-control" name="option41"></th>
					  			</tr>				
					  			<tr>
					  				<th>Correct</th>
					  				<th>
					  				<select class="form-control" name="correct1">
                                         <option value ="A"> A </option>
                                         <option value ="B"> B </option>
                                         <option value ="C"> C </option>
                                         <option value ="D"> D </option>
                                    </select>
                                    </th>
					  			</tr>					  			
					  		</tbody>
					  	</table>
					  </div>			
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-warning btn-circle btn-xl" data-dismiss="modal"><i class="fa fa-times"></i></button>
		        <button type="submit" class="btn btn-info btn-circle btn-xl"><i class="fa fa-check" data-submit="form"></i></button>
		      </div>
		    </div>
		  </div>
		  </form>
		</div>  
        
        <!-- #Modal Insert -->
        
        <!-- Modalconfirmdelete -->
        		<!--Modal: modalConfirmDelete-->
			<form action="deleteQuestion" method="post">
			<div class="modal fade" id="modalConfirmDelete" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
			  aria-hidden="true">
			  <div class="modal-dialog modal-sm modal-notify modal-danger" role="document">
			    <!--Content-->
			    <div class="modal-content text-center">
			      <!--Header-->
			      <div class="modal-header d-flex justify-content-center">
			        <p class="heading">Are you sure to delete this question?</p>  
			        <input class="form-control" name="id3" id="myText7" readonly>      
			      </div>
		
			      <!--Body-->
			      <div class="modal-body">	
			        <i class="fa fa-times fa-4x animated rotateIn"></i>				
			      </div>
			
			      <!--Footer-->
			      <div class="modal-footer flex-center">
			        <button type="button" class="btn btn-warning btn-circle btn-xl" data-dismiss="modal"><i class="fa fa-times"></i></button>
			        <button type="submit" class="btn btn-info btn-circle btn-xl"><i class="fa fa-check" data-submit="form"></i></button>
			      </div>
			    </div>
			    <!--/.Content-->
			  </div>
			</div>
			</form>
		<!--Modal: modalConfirmDelete-->
        <!-- #modalconfirmdelete -->
        <!-- Modal import -->
          		<!-- Modal Edit -->
		<div class="modal fade" id="modalImport" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<form action="importCauHoiFromFile" method="post">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Import Question !</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">

					  <div class="table-responsive">
					  	<table class="table table-hover">
					  		<thead>
					  			<tr>
					  				<th>#</th>
					  				<th>Input</th>
					  			</tr>
					  		</thead>
					  		<tbody>
					 	 		<tr>
					  				<th>Select file </th>	
					  				<th><input type="file" class="form-control" name="fileinput"></th>			  				
					  			</tr>					  							  			
					  		</tbody>
					  	</table>
					  </div>			
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-warning btn-circle btn-xl" data-dismiss="modal"><i class="fa fa-times"></i></button>
		        <button type="submit" class="btn btn-info btn-circle btn-xl"><i class="fa fa-check" data-submit="form"></i></button>
		      </div>
		    </div>
		  </div>
		  </form>
		</div>  
			
        
        <!-- /#wrapper -->

        <!-- jQuery -->
        <script src="View/admin/js/jquery.min.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="View/admin/js/bootstrap.min.js"></script>

        <!-- Metis Menu Plugin JavaScript -->
        <script src="View/admin/js/metisMenu.min.js"></script>

        <!-- DataTables JavaScript -->
        <script src="View/admin/js/dataTables/jquery.dataTables.min.js"></script>
        <script src="View/admin/js/dataTables/dataTables.bootstrap.min.js"></script>

        <!-- Custom Theme JavaScript -->
        <script src="View/admin/js/startmin.js"></script>

        <!-- Page-Level Demo Scripts - Tables - Use for reference -->
        <script>
            $(document).ready(function() {
                $('#dataTables-example').DataTable({
                        responsive: true
                });
            });
        </script>
         <script>
			function myFunction(a,b,c,d,e,f) {
			    document.getElementById("myText1").value =a 
			    document.getElementById("myText2").value =b
			    document.getElementById("myText3").value =c 
			    document.getElementById("myText4").value =d 
			    document.getElementById("myText5").value =e 
			    document.getElementById("myText6").value =f 
			}
		</script>
        <script>
			function myFunctionDelete(a) {
			    document.getElementById("myText7").value =a 
			}
		</script>


    </body>
</html>
