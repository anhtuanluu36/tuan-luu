<script type="text/javascript">
 	$( document ).ready(function() {
 		var data = {
 			studentId : 1,
 			studentName : 'Tuan',
 		};
 		$.ajax({
 		    type: "post",
 		    url: "ajax/list", //your valid url
 		    contentType: "application/json", //this is required for spring 3 - ajax to work (at least for me)
 		   	dataType: 'json',
 		    data: JSON.stringify(data), //json object or array of json objects
 		    success: function(result) {
 		        alert(result);
 		    },
 		    error: function(jqXHR, textStatus, errorThrown){
 		        console.debug(jqXHR);
 		    }
 		});
 		});
	</script>
<h1>Hello World!</h1>
<p>This is the homepage!</p>
