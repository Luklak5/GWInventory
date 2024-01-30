/**
 * 
 */
 
function filter() {
	let checkboxes = document.getElementsByTagName("input");
    let rows = document.getElementById('tabl').getElementsByTagName("tr");
    console.log(rows.length);
    for(let r = 0;r<rows.length;r++)
    {
    	let cols = rows[r].getElementsByTagName('td');
    	console.log(cols.length);
      	rows[r].style = "display: table-row";
        //let value1 = checkboxes[0].value.toLocaleUpperCase();
        //let value2 = checkboxes[1].value.toLocaleUpperCase();
        let cvalue1 = cols[3].innerText.toLocaleUpperCase();
        let cvalue2 = cols[4].innerText.toLocaleUpperCase();
        if(cvalue1 === 0 && checkboxes[0].checked === true)
        {
			rows[r].style = "display: none";
		}
		if(cvalue2 === true && checkboxes[1].checked === true)
        {
			rows[r].style = "display: none";
		}
    }
}
