"use strict";

$(function () {
	let total = 0;
	let total2 = 0;
	let total3=0;
	$('input:radio[name="size"]').change(function() {
		if($('input:radio[name="size"]:checked').val()=="M"){
			total=$("#priceM").val();
		}else{
			total=$("#priceL").val();
		}
		total=parseInt(total);
		let totalAll = (total+total2)*total3;
		$("#total-price").text(totalAll+"円");
	}).trigger('change');
	
	
	let top2 =0;
	$('input:checkbox[name="orderToppings"]').change(function() {
        let top = $('#topping input:checkbox:checked').length;
        if($('input:radio[name="size"]:checked').val()=="M"){
			if(top2>top){
				total2 = total2 - 200;
			}else{
				total2 = total2 + 200;
			}
		}else if($('input:radio[name="size"]:checked').val()=="L"){
			if(top2>top){
				total2 = total2 - 300;
			}else{
				total2 = total2 + 300;
			}
		}
		top2=top;
		
		let totalAll = (total+total2)*total3;
		$("#total-price").text(totalAll+"円");
    });

    $('#quantity').change(function() {
		total3 = $("#quantity").val();
		
		let totalAll = (total+total2)*total3;
		$("#total-price").text(totalAll+"円");
	
	}).trigger('change');
	
	
	
});