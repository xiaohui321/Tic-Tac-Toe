/* 0: empty
 * 1: user
 * 10: computer
 * values[0,10,20...80]: result for each subgrid 
 * values[1-9,11-19...,81-89] result for each cell
 */
var played_games;
var winned_games;

var values = new Array();
var selected_cell;
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

function checkOverallResult(){

}

function ComputerSelect(){
    var m = Math.floor(Math.random()*89 + 1);
    while(m%10 == 0 || values[m] != 0){
	m++;
	if(m > 89) m = 1;
    }
    document.getElementById(m.toString()).className = "childCube computer";
    values[m] = 10;
    return m;
}

function UserSelect(n){
    
   if(values[n] != 0)
       return;

    selected_cell ++;
    values[n] = 1;
    
    //checkSingleResult(n);
    if(selected_cell >= 81)
	alert("Tie Game!");

    var m = ComputerSelect();
    //checkSingleResult(m);
}

function reset(){	
    while(values.length > 0) 
	values.pop();
    for(var i = 0; i < 90; i++) 
	values.push(0);  	   
}

function init(){
    played_games = 0;
    winned_games = 0;
    selected_cell = 0;
    reset();
}

$(document).ready(function(){
    init();

    $('.empty').click(function(){
	$(this).addClass('user');
	$(this).removeClass('empty');
	UserSelect(this.id);
    });

    $('.empty').mouseenter(function(){
	$(this).addClass('selected');
    });
    
    $('.empty').mouseleave(function(){
	$(this).removeClass('selected');
    });
});


