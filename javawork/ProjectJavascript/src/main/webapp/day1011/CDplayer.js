$(function(){
	//h1.title을 클릭시 .music-list를 slideDown 한다
	$("h1.title").click(function(){
			$("ul.music-list").slideDown('slow');
	});
	//노래 제목을 클릭시 클릭한 곳의 제목을 얻어서 h1.title에 넣은 후 slideUp 한다
	$("ul.music-list li").click(function(){
			let title=$(this).text();
			$("h1.title").text(title);
			
			let selectClass=$(this).attr("class");
			$("#cd").animate({width:'0'},'slow',function(){
				$("#cd").attr("class",selectClass);
				$(this).animate({width:'300px'},'slow');
			});
			
			$("ul.music-list").slideUp('slow');
	});
	 
});