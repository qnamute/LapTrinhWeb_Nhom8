<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="icon" href="img/favicon.png" type="image/png">
        <title>Lap Trinh Web - Nhom 8</title>
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
						<a class="navbar-brand logo_h" href="HomeForward"></a>
						<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse offset" id="navbarSupportedContent">
							<ul class="nav navbar-nav menu_nav ml-auto">
								<li class="nav-item"><a class="nav-link" href="HomeForward">Home</a></li> 
								<li class="nav-item submenu dropdown">
								</li> 
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
							<a href="HomeForward">Home</a>
							<a href="services.html">Result</a>
						</div>
						<h2>Result</h2>
					</div>
				</div>
            </div>
        </section>
        <!--================End Home Banner Area =================-->
        
        <!--================Feature Area =================-->
        <section class="feature_area p_120">
            <div class="container">
            	<div class="banner_content text-center" id="startDiv">
            		<div class="banner_content text-center">
        			<h2>Here is your Result</h2>
              	    </div>             		
            	</div>
                <div class="main_title">				
                </div>
            </div>
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
							    </tbody>							    
							</table>  
							</c:forEach>								
        				</div>        			
        			</div>
        			<div class="col-lg-6">
        				<div class="serve_text">
        					<h4>Exam name : ${nameexam}</h4>
	        				<table class="table"> 	 
							      <thead class="thead-dark">
								    <tr>
								      <th scope="col">Correct Answer</th>
								      <th scope="col">Incorrect Answer</th>
								      <th scope="col">Null</th>
								    </tr>
								  </thead>	
								  <tbody>									  
									  	<tr>
									  		<th>${correct}</th>
									  		<th>${incorrect}</th>
									  		<th>${answernull}</th>
									  	</tr>
								  </tbody>
								</table> 
        				</div>
        			</div>
        		</div>
        </section>
        <!--================End Feature Area =================-->
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