const url = "http://localhost:8090/api/v1/persons";

// fetch(`${url}/donators`)
//     .then(res => {
//         return res.json();
//     })
//     .then(data => {
//         console.log(data);

//     });

fetch(`${url}`)
	.then((res) => {
		return res.json();
	})
	.then((data) => {
		console.log(data);

		let table = document.createElement("table");
		let thead = document.createElement("thead");
		let tbody = document.createElement("tbody");

		table.appendChild(thead);
		table.appendChild(tbody);

		// js에서 테이블 생성 by #table
		document.getElementById("table").appendChild(table);

		// 테이블 헤더 생성
		let row_head = document.createElement("tr");
		let heading_1 = document.createElement("th");
		heading_1.innerHTML = "name";
		let heading_2 = document.createElement("th");
		heading_2.innerHTML = "email";
		let heading_3 = document.createElement("th");
		heading_3.innerHTML = "benefit";
		let heading_4 = document.createElement("th");
		heading_4.innerHTML = "donation name";
		let heading_5 = document.createElement("th");
		heading_5.innerHTML = "benefit name";

		row_head.appendChild(heading_1);
		row_head.appendChild(heading_2);
		row_head.appendChild(heading_3);
		row_head.appendChild(heading_4);
		row_head.appendChild(heading_5);
		thead.appendChild(row_head);

		for (index = 0; index < data.length; index++) {
			let row_body = document.createElement("tr");
			let row_body_data_1 = document.createElement("td");
			row_body_data_1.innerHTML = data[index].name;
			let row_body_data_2 = document.createElement("td");
			row_body_data_2.innerHTML = data[index].email;
			let row_body_data_3 = document.createElement("td");
			row_body_data_3.innerHTML = data[index].benefit;


			let row_body_data_4 = document.createElement("td");
            
            			let listD = data[index].donation;

			if(listD == 1) {
				listD = "국어"
			} else if(listD == 2) {
				listD = "수학"
			} else if(listD == 3) {
				listD = "영어"
			} else if(listD == 4) {
				listD = "피아노"
			} else if(listD == 5) {
				listD = "노래"
			} else if(listD == 6) {
				listD = "마술"
			} else if(listD == 7) {
				listD = "보건 및 의료"
			} else if(listD == 8) {
				listD = "무료법률상담"
			} else if(listD == 9) {
				listD = "청소년 상담"
			} else if(listD == 10){
				listD = "JAVA 코딩 교육"
			} else{
				listD = "없음"
			}

			row_body_data_4.innerHTML = listD;

			let row_body_data_5 = document.createElement("td");
            
           
			let listB = data[index].benefit;

			if(listB == 1) {
				listB = "국어"
			} else if(listB == 2) {
				listB = "수학"
			} else if(listB == 3) {
				listB = "영어"
			} else if(listB == 4) {
				listB = "피아노"
			} else if(listB == 5) {
				listB = "노래"
			} else if(listB == 6) {
				listB = "마술"
			} else if(listB == 7) {
				listB = "보건 및 의료"
			} else if(listB == 8) {
				listB = "무료법률상담"
			} else if(listD == 9) {
				listB = "청소년 상담"
			} else if(listD == 10){
				listB = "JAVA 코딩 교육"
			} else{
				listB = "없음"
			}

			row_body_data_5.innerHTML = listB;


			row_body.appendChild(row_body_data_1);
			row_body.appendChild(row_body_data_2);
			row_body.appendChild(row_body_data_3);
			row_body.appendChild(row_body_data_4);
			row_body.appendChild(row_body_data_5);
            tbody.appendChild(row_body);
		}
	});
