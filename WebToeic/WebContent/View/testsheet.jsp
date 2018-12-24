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

								<li class="nav-item"><a class="nav-link" href="#">Time left: &nbsp; <span id="showmns">00</span>:<span id="showscs">00</span></a></li>
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
							<a href="services.html">Exam</a>
						</div>
						<h2>Exam</h2>
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
        			<h2>Click "Start" to start your exam</h2>
              	    </div>  
            		<form action="#" method="post">
						Minutes: <input type="text" id="mns" name="mns" value="${time}" size="3" maxlength="3" readonly />
						Second: <input type="text" id="scs" name="scs" value="0" size="2" maxlength="2"	readonly />
						<input type="button" class="btn btn-info" id="btnct" value="START THE EXAM" onclick="showDiv()"/> 
					</form>
            	</div>
                <div class="main_title">
					<div id="welcomeDiv"  style="display:none;" class="answer_list" >
                    <form action="getResultTheExam" method="post" id="formSheetTest">
                        <h2>
                            <%=request.getAttribute("msg") != null ? request.getAttribute("msg") : " "%>
                        </h2>
                        <div class="projects_text">
                        <input class="form-control" name="nameexam" value="${nameexam}" readonly>
                        </div>
                        <input class="form-control" name="examid" type="hidden" value="${examid}">
                        <br>                  
                        <br>
                        <div>
                        <c:forEach items="${lch}" var="list">   
                            <h4>${list.soThuTu}.${list.noiDung}</h4>
                        
                            <label><input type="radio" name="ans[${list.soThuTu}]" value="A"> ${list.option1}</label>
                            <br>
                            <label><input type="radio" name="ans[${list.soThuTu}]" value="B"> ${list.option2}</label>
                            <br> 
                            <label><input type="radio" name="ans[${list.soThuTu}]" value="C"> ${list.option3}</label>
                            <br>
                            <label><input type="radio" name="ans[${list.soThuTu}]" value="D"> ${list.option4}</label>
                            <br>    
                        </c:forEach>
                        </div>
                        <br><button type="submit" class="btn btn-info"><i data-submit="form">Finish</i></button>		
                    </form>
                    </div>
                </div>
            </div>
        </section>
        <!--================End Feature Area =================-->
        <!-- Optional JavaScript -->
        <script>
        function CountdownTimer(obnm){
   		 // https://coursesweb.net/javascript/
   		  var endct =0;  // it is set to 1 when script starts
   		  var ctmnts =0;  // minutes
   		  var ctsecs =0;  // seconds
   		  var startchr =0;  // used to control when to read data from form, and script finished
   		  var ctpause =-1;  //if -1, pause the script
   		
   		  //get html elms.
   		  var el_showmns = document.getElementById('showmns');
   		  var el_showscs = document.getElementById('showscs');
   		  var el_mns = document.getElementById('mns');
   		  var el_scs = document.getElementById('scs');
   		  var el_btnct = document.getElementById('btnct');
   		  var el_btnct_res = document.getElementById('btnct_res');
   		  var el_btnct_end = document.getElementById('btnct_end');
   		
   		  //to start/pause/resume Countdown Timer
   		  function startPauseCT(){
   		    if(parseInt(el_mns.value) >0 || parseInt(el_scs.value)>0 || endct ==1){
   		      ctpause *=-1;
   		      if(ctpause ==1){ //Start and set next click as Pause
   		        el_btnct.value ='PAUSE';
   		        window[obnm].countdownTimer();
   		      }
   		      else el_btnct.value ='RESUME';
   		    }
   		  }
   		
   		  // HERE YOU CAN ADD TO EXECUTE JavaScript instructions WHEN COUNTDOWN TIMER REACHES TO 0
   		  function endCT(){
   		    // HERE ADD YOUR CODE
   			  document.getElementById("formSheetTest").submit();
   		    return false;
   		  }
   		
   		  this.countdownTimer = function(){
   		    // if $startchr is 0, and form fields exists, gets data for minutes and seconds, and sets $startchr to 1
   		    if(startchr == 0 && el_mns && el_scs) {
   		      // makes sure the script uses integer numbers
   		      ctmnts = parseInt(el_mns.value);
   		      ctsecs = parseInt(el_scs.value);
   		
   		      // if data not a number, sets the value to 0
   		      if(isNaN(ctmnts)) ctmnts = 0;
   		      if(isNaN(ctsecs)) ctsecs = 0;
   		
   		      // rewrite data in form fields to be sure that the fields for minutes and seconds contain integer number
   		      el_mns.value = ctmnts;
   		      el_scs.value = ctsecs;
   		      startchr = 1;
   		    }
   		
   		    if(ctmnts >0 || ctsecs >0) endct =1;  //to can call endCT() at the ending
   		
   		    // if minutes and seconds are 0, call endCT()
   		    if(ctmnts==0 && ctsecs==0 && endct ==1){
   		      startchr =0;
   		      ctpause =-1;
   		      endct =0;
   		      el_btnct.value ='START';
   		      endCT();
   		    }
   		    else if(startchr ==1 && ctpause ==1){
   		      // decrease seconds, and decrease minutes if seconds reach to 0
   		      ctsecs--;
   		      if(ctsecs < 0){
   		        if(ctmnts > 0) {
   		          ctsecs = 59;
   		          ctmnts--;
   		        }
   		        else {
   		          ctsecs = 0;
   		          ctmnts = 0;
   		        }
   		      }
   		      setTimeout(obnm +'.countdownTimer()', 1000); //auto-calls this function after 1 seccond
   		    }
   		
   		    // display the time in page
   		    el_showmns.innerHTML = ctmnts;
   		    el_showscs.innerHTML = ctsecs;
   		  }
   		
   		  //set event to button that starts the Countdown Timer
   		  if(el_btnct) el_btnct.addEventListener('click', startPauseCT);
   		
   		  //restart Countdown Timer from the initial values
   		  if(el_btnct_res) el_btnct_res.addEventListener('click', function(){ startchr =0; if(ctpause ==-1) startPauseCT(); });
   		
   		  //ending Countdown Timer, sets 0 form data
   		  if(el_btnct_end) el_btnct_end.addEventListener('click', function(){ el_mns.value =0; el_scs.value =0; startchr =0; startPauseCT(); });
   		}
   		
   		var obCT = new CountdownTimer('obCT');
   		</script>
   		<script>
   		function showDiv() {
	   		document.getElementById('welcomeDiv').style.display = "block";
	   		document.getElementById('startDiv').style.display = "none";
   		}
   		</script>
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