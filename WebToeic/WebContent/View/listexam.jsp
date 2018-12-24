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
								<li class="nav-item"><a class="nav-link" href="about-us.html">About</a></li> 
								<li class="nav-item"><a class="nav-link" href="service.html">Services</a>
								<li class="nav-item submenu dropdown active">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Exam</a>
									<ul class="dropdown-menu">
										<li class="nav-item"><a class="nav-link" href="showListExam">Portfolio</a>
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
							<a href="HomeForward">Home</a>
							<a href="showListExam">Exam</a>
						</div>
						<h2>List Exam</h2>
					</div>
				</div>
            </div>
        </section>
        <!--================End Home Banner Area =================-->
        
        <!--================Projects Area =================-->
        <section class="projects_area p_120">
        	<div class="container">
        		<div class="projects_fillter row">
					<div class="col-lg-7">
						<div class="main_title">
							<h2>List exam</h2>
							<p>Complete the test before the time runs out</p>
						</div>
					</div>
				</div>
				<div class="projects_inner row">
					<c:forEach items="${listexam}" var="list">
					<div class="col-lg-4 col-sm-6">
					<form action="getTestSheet">
						<div class="projects_item">
							<input class="form-control" name="examid" type="hidden" value="${list.maDeThi}">
							<input class="form-control" name="nameexamid" type="hidden" value="${list.tenDeThi}">
							<img class="img-fluid" src="img/projects/projects-1.jpg" alt="">
							<div class="projects_text">
								<h4>${list.tenDeThi}</h4>
								<h4>${list.tenLopHoc}</h4>
								<table>
									<tr>
										<th>Start time :</th>
										<th>${list.thoiGianBatDau}</th>
									</tr>
									<tr>
										<th>End time :</th>
										<th>${list.thoiGianKetThuc}</th>
									</tr>
									<tr>
										<th>Total time :</th>
										<th>${list.thoiGianThi} (minutes)</th>
									</tr>
								</table>
								<br>
								<button type="submit" class="btn btn-info"><i data-submit="form">Do the exam now</i></button>	
							</div>
						</div>
						</form>
                    </div>
                    </c:forEach>			
				</div>
        	</div>
        </section>
        <!--================End Projects Area =================-->
          
        
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