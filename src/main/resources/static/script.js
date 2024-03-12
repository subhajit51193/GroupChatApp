
function showMessage(message){
	
}


var stompClient = null;
function connect(){
	
	let socket = new SockJS("/server1");
	stompClient = Stomp.over(socket);
	
	stompClient.connect({},function(frame){
		console.log("connected"+frame);
		$("#name-from").addClass("d-none");
		$("#chat-room").removeClass("d-none");
		
		//subscribe
		stompClient.subscribe("/topic/return-to",function(response){
			
			showMessage(JSON.parse(response.body));
		})
	});
}



$(document).ready(e=>{
	
	$("#login").click(()=>{
		
		let name  = $("#name-value").val();
		localStorage.setItem("name",name);
		
		connect();
	})
})