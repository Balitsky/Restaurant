$(document).ready(
		function() {
			/*
			 * var id = JQuery(".idcategory").val();
			 * 
			 * $(".accordion h3").eq(id).addClass("active"); $(".accordion
			 * .content").eq(id).show();
			 */
			$(".accordion h3").click(
					function() {
						$(this).next(".content").slideToggle("slow").siblings(
								".content:visible").slideUp("slow");
						$(this).toggleClass("active");
						$(this).siblings("h3").removeClass("active");
					});
		});