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

        <title>Startmin - Bootstrap Admin Theme</title>

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
                    <a class="navbar-brand" href="displayExamManager">Startmin</a>
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
                            <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
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
                                <a href="displayExamManager" class="active"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                            </li>

                           <li>
                                <a href="displayExamManager"><i class="fa fa-sticky-note fa-fw"></i>Exam Manager</a>
                            </li>  
                            
                             <li>
                                <a href="displayExam_Class"><i class="fa fa-toggle-on fa-fw"></i>Exam for class</a>
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
                                    Exam List
                                </div>
                                <!-- /.panel-heading -->
                                <div class="panel-body">
                                    <div class="table-responsive">
                                        <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                            <thead>
                                                <tr>
                                                    <th>Id</th>
                                                    <th>Exam Name</th>
                                                    <th>Number of questions</th>
                                                    <th>Time (Minute))</th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${listexam}" var="list">
                                            	    <tr class="odd gradeX">
                                                   		<td>${list.maDeThi}</td>
                                                        <td>${list.tenDeThi}</td>
                                                        <td>${list.soLuongCauHoi}</td>
                                                        <td>${list.thoiGianThi}</td>                                                  
                                                        <td class="center"><button type="button" class="btn btn-danger" data-toggle="modal" data-target="#modalConfirmDelete" onclick="myFunctionDelete('${list.maDeThi}')">Delete</button></td>
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
                     	<p> <button type="button" class="btn btn-warning btn-lg" data-toggle="modal" data-target="#exampleModal">Create new exam</button></p>
                     </div>                                       
                </div>
            </div> -->
        </div>           
        <!-- /#wrapper -->
        <!-- Modal -->
       <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<form action="createExam" method="post">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Create new exam !</h5>
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
					  				<th>Exam Name</th>
					  				<th><input class="form-control" name="examname1"></th>
					  			</tr>
					  			<tr>
					  				<th>Number of questions</th>	
					  				<th><input class="form-control" name="numberquestion1"></th>			  				
					  			</tr>
					  			<tr>
					  				<th>Time</th>
									<th><input class="form-control" name="time1"></th>
					  			</tr>
					  			<tr>
					 				<th>Number of Easy Question !</th>
					 				<th><input class="form-control" name="easy1"></th>
					  			</tr>
					  			<tr>
					 				<th>Number of Medium Question !</th>
					 				<th><input class="form-control" name="medium1"></th>
					  			</tr>
					  			<tr>
					 				<th>Number of Hard Question !</th>
					 				<th><input class="form-control" name="hard1"></th>
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
        <!--Modal: modalConfirmDelete-->
		<form action="deleteExam" method="post">
		<div class="modal fade" id="modalConfirmDelete" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
		  aria-hidden="true">
		  <div class="modal-dialog modal-sm modal-notify modal-danger" role="document">
		    <!--Content-->
		    <div class="modal-content text-center">
		      <!--Header-->
		      <div class="modal-header d-flex justify-content-center">
		        <p class="heading">Are you sure to delete this exam?</p>  
		        <input class="form-control" name="examid1" id="myText1" readonly>      
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
			function myFunctionDelete(a) {
			    document.getElementById("myText1").value =a 
			}
		</script>

    </body>
</html>
