/* 0: empty
 * 1: user
 * 2: computer
 * v[0]: result, and  1-9 are the status for each grid 
 */

var values_0_0 = new Array();
function checkSingleResult(array) {
	if(array[0] != '0')
		return array[0];
	if()
}





function reset(){
	
	while(values_0_0.length > 0) values_0_0.pop();
	for(var i = 0; i < 9; i++){
		values_0_0.push('0');  			
	}

}

$(document).ready(function(){
	reset();


	$('.empty').click(function(){
		$(this).addClass('user');
	});
});


