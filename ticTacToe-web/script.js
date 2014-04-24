/* 0: empty
 * 1: user
 * 10: computer
 * v[0]: result, and  1-9 are the status for each grid 
 */
var played_games;
var winned_games;

var values = new Array();
var results = new Array();

function checkSingleResult(array) {
    //return result if already determined
    if(array[0] != 0) return array[0];
    
    var sum = 0;
    for(var i = 1; i < 10; i++) sum += array[i]; 

    if(sum/10 >= 3){
	if (array[5] == 10){
	    if((array[1] == 10 && array[9] == 10) ||
	       (array[2] == 10 && array[8] == 10) ||
	       (array[3] == 10 && array[7] == 10) ||
	       (array[4] == 10 && array[6] == 10)){
		array[0] = 10;
		return 10;
	    }
	}else{
	    if((array[1] == 10 && array[2] == 10 && array[3] == 10) ||
	       (array[1] == 10 && array[4] == 10 && array[7] == 10) ||
	       (array[3] == 10 && array[6] == 10 && array[9] == 10) ||
	       (array[7] == 10 && array[8] == 10 && array[9] == 10)){
		array[0] = 10;
		return 10;
	    }
	}
    }else if(sum%10 >= 3) {
	if (array[5] == 1){
	    if((array[1] == 1 && array[9] == 1) ||
	       (array[2] == 1 && array[8] == 1) ||
	       (array[3] == 1 && array[7] == 1) ||
	       (array[4] == 1 && array[6] == 1)){
		array[0] = 1;
		return 1;
	    }
	}else{
	    if((array[1] == 1 && array[2] == 1 && array[3] == 1) ||
	       (array[1] == 1 && array[4] == 1 && array[7] == 1) ||
	       (array[3] == 1 && array[6] == 1 && array[9] == 1) ||
	       (array[7] == 1 && array[8] == 1 && array[9] == 1)){
		array[0] = 1;
		return 1;
	    }
	}
    }
    return 0;
}

function reset(){	
    while(values_0.length > 0) values_0.pop();
    for(var i = 0; i < 10; i++) values_0.push(0);
  			
}

function UserSelect(n){

}

function init(){
    played_games = 0;
    winned_games = 0;

    reset();
}

$(document).ready(function(){
    
    console.log("hi!");
    $('div .empty').click(function(){
	$(this).addClass('user');
	$(this).removeClass('empty');
    });
});


