<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="icon" href="img/favicon.png" type="image/png">
        <title>Ronald Usiness Multi</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="vendors/linericon/style.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="vendors/owl-carousel/owl.carousel.min.css">
        <link rel="stylesheet" href="vendors/lightbox/simpleLightbox.css">
        <link rel="stylesheet" href="vendors/nice-select/css/nice-select.css">
        <link rel="stylesheet" href="vendors/animate-css/animate.css">
        <link rel="stylesheet" href="vendors/popup/magnific-popup.css">
        <!-- main css -->
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/responsive.css">
    </head>
    <body>
        
        <!--================Header Menu Area =================-->
        <header class="header_area">
            <div class="main_menu">
            	<nav class="navbar navbar-expand-lg navbar-light">
					<div class="container box_1620">
						<!-- Brand and toggle get grouped for better mobile display -->
						<a class="navbar-brand logo_h" href="homeStudentForward"><img src="img/logo.png" alt=""></a>
						<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse offset" id="navbarSupportedContent">
							<ul class="nav navbar-nav menu_nav ml-auto">
								<li class="nav-item"><a class="nav-link" href="homeStudentForward">Home</a></li> 
								<li class="nav-item active"><a class="nav-link" href="about-us.html">Information</a></li> 
								<li class="nav-item"><a class="nav-link" href="service.html">Services</a>
								<li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Pages</a>
									<ul class="dropdown-menu">
										<li class="nav-item"><a class="nav-link" href="portfolio.html">Portfolio</a>
										<li class="nav-item"><a class="nav-link" href="portfolio-details.html">Portfolio Details</a>
										<li class="nav-item"><a class="nav-link" href="elements.html">Elements</a></li>
									</ul>
								</li> 
								<li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Blog</a>
									<ul class="dropdown-menu">
										<li class="nav-item"><a class="nav-link" href="blog.html">Blog</a></li>
										<li class="nav-item"><a class="nav-link" href="single-blog.html">Blog Details</a></li>
									</ul>
								</li> 
								<li class="nav-item"><a class="nav-link" href="contact.html">Contact</a></li>
							</ul>
							<ul class="nav navbar-nav navbar-right">
								<li class="nav-item"><a href="#" class="search"><i class="lnr lnr-magnifier"></i></a></li>
							</ul>
						</div> 
					</div>
            	</nav>
            </div>
        </header>
        <!--================Header Menu Area =================-->
        
        <!--================Home Banner Area =================-->
        <section class="banner_area">
            <div class="banner_inner d-flex align-items-center">
				<div class="container">
					<div class="banner_content text-center">
						<div class="page_link">
							<a href="homeStudentForward">Home</a>
							<a href="about-us.html">Account</a>
						</div>
						<h2>Account Information</h2>
					</div>
				</div>
            </div>
        </section>
        <!--================End Home Banner Area =================-->
        
        <!--================Serve Area =================-->
        <section class="serve_area p_120">
        	<div class="container">
        		<div class="serve_inner row">      	    			
        			<div class="col-lg-6">
        				<div class="serve_text">
        				    <c:forEach items="${student}" var="list">
        					<h4>Username: @${list.tenDangNhap}</h4>   
        					<table class="table"> 	 
						      <thead class="thead-dark">
							    <tr>
							      <th scope="col">#</th>
							      <th scope="col">Information</th>
							      <th scope="col"></th>
							    </tr>
							  </thead>	
							  <tbody>
							    <tr>
							      <th scope="col">Full name</th>
							      <th>${list.hoVaTen}</th>	
							      <th></th>						      														 
							    </tr>
							    <tr>
							      <th scope="col">Year of Birth</th>
							      <th>${list.namSinh}</th>	
							      <th></th>		
							    </tr>
							    <tr>
							      <th scope="col">Sex</th>
							      <th>${list.gioiTinh}</th>		
							      <th></th>	
							    </tr>
							    <tr>
							      <th scope="col">Email</th>
							      <th>${list.email}</th>	
							      <th></th>		
							    </tr>
							    <tr>
							      <th scope="col"></th>
							      <th><td class="center"><button type="button" class="btn btn-info" data-toggle="modal" data-target="#modalEdit" onclick="myFunction('${list.tenDangNhap}', '${list.hoVaTen}','${list.namSinh}','${list.email}')">Edit info</button></td></th>		
							    </tr>
							    </tbody>							    
							</table>  
							</c:forEach>   
							
							<h5>List of attendance classes</h5>
							
							<table class="table"> 	 
						      <thead class="thead-dark">
							    <tr>
							      <th scope="col">#</th>
							      <th scope="col">Class Name</th>
							    </tr>
							  </thead>	
							  <tbody>
								  <c:forEach items="${lophoc}" var="listclass">
								  	<tr>
								  		<th>${listclass.maLopHoc}</th>
								  		<th>${listclass.tenLopHoc}</th>
								  	</tr>
								  </c:forEach> 
							  </tbody>
							</table>   
											
        				</div>        			
        			</div>
        			<div class="col-lg-6">
        				<div class="serve_img"><img class="img-fluid" src="img/about-1.jpg" alt=""></div>
        			</div>
        		</div>
        	</div>
        </section>
        <!-- Modal -->
        <div class="modal fade" id="modalEdit" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<form action="editInfo_byStudent" method="post">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Update Account !</h5>
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
					  		<c:forEach items="accountinfo" var="list">
					  			<tr>
					  				<th>Username</th>
					  				<th><input class="form-control" name="username2" id="myText1" readonly></th>
					  			</tr>
					  			<tr>
					  				<th>Fullname</th>
					  				<th><input class="form-control" name="fullname2" id="myText2"></th>
					  			</tr>
					  			<tr>
					  				<th>Year of birth</th>
					  				<th><input class="form-control" name="namsinh2" id="myText3"></th>
					  			</tr>
					  			<tr>
					  				<th>Sex</th>
					  				<th>
					  					<select class="form-control" name="sex2">
                                                        <option value = "Male">Male</option>
                                                        <option value = "Female">Female</option>
                                        </select>
					  					
					  				</th>
					  			</tr>				
					  			<tr>
					  				<th>Email</th>
					  				<th><input class="form-control" name="email2" type="email" id="myText4"></th>
					  			</tr>
					  		</c:forEach>					  			
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
		
		<script>
			function myFunction(a,b,c,d) {
			    document.getElementById("myText1").value =a 
			    document.getElementById("myText2").value =b
			    document.getElementById("myText3").value =c 
			    document.getElementById("myText4").value =d 
			}
		</script>
        <!--================End Serve Area =================-->
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/popper.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/stellar.js"></script>
        <script src="vendors/lightbox/simpleLightbox.min.js"></script>
        <script src="vendors/nice-select/js/jquery.nice-select.min.js"></script>
        <script src="vendors/isotope/imagesloaded.pkgd.min.js"></script>
        <script src="vendors/isotope/isotope-min.js"></script>
        <script src="vendors/owl-carousel/owl.carousel.min.js"></script>
        <script src="js/jquery.ajaxchimp.min.js"></script>
        <script src="vendors/counter-up/jquery.waypoints.min.js"></script>
        <script src="vendors/counter-up/jquery.counterup.js"></script>
        <script src="js/mail-script.js"></script>
        <script src="vendors/popup/jquery.magnific-popup.min.js"></script>
        <script src="js/theme.js"></script>
    </body>
</html>