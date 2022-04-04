const btn = document.getElementById("Section__search__btn");
var select = document.getElementById("talentList");
var choice;
var num;
function printChoice() {
	choice = select.options[select.selectedIndex].value;
	// console.log(choice);
	async function request() {
		const response = await fetch(
			`http://localhost:8090/api/v1/persons/talent?talentId=${choice}`,
			{
				method: "GET",
			}
		);
		const data = await response.json();
		console.log(data);
	}
	request();
}
function choiceNum() {
	num = select.options[select.selectedIndex].value;

	console.log(num);

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

			document.getElementById("talentInDonation").textContent = ""; // 요청마다 table 초기화

			let talentInDonation = document.createElement("table");
			let talentInDonationHead = document.createElement("thead");
			let talentInDonationBody = document.createElement("tbody");

			talentInDonation.appendChild(talentInDonationHead);
			talentInDonation.appendChild(talentInDonationBody);

			// js에서 테이블 생성 by #table
			document.getElementById("talentInDonation").appendChild(talentInDonation);

			// 테이블 헤더 생성
			let talentInDonationRow_head = document.createElement("tr");
			let talentInDonationHeading_1 = document.createElement("th");
			talentInDonationHeading_1.innerHTML = "이름";
			let talentInDonationHeading_2 = document.createElement("th");
			talentInDonationHeading_2.innerHTML = "email";
			// let talentInDonationHeading_3 = document.createElement("th");
			// talentInDonationHeading_3.innerHTML = "donation";
			let talentInDonationHeading_4 = document.createElement("th");
			talentInDonationHeading_4.innerHTML = "기부 재능";

			talentInDonationRow_head.appendChild(talentInDonationHeading_1);
			talentInDonationRow_head.appendChild(talentInDonationHeading_2);
			// talentInDonationRow_head.appendChild(talentInDonationHeading_3);
			talentInDonationRow_head.appendChild(talentInDonationHeading_4);
			talentInDonationHead.appendChild(talentInDonationRow_head);

			for (index = 0; index < data.length; index++) {
				// if(data[index].donation == num || data[index].benefit == num) {

				let row_body = document.createElement("tr");
				let row_body_name = document.createElement("td");
				row_body_name.innerHTML = data[index].name;
				let row_body_email = document.createElement("td");
				row_body_email.innerHTML = data[index].email;
				// let row_body_num = document.createElement("td");
				// row_body_num.innerHTML = num;

				if (data[index].donation == num) {
					let row_body_donation = document.createElement("td");

					// if(num == null) {
					//     continue
					// }
					let listD;

					if (num == 1) {
						listD = "국어";
					} else if (num == 2) {
						listD = "수학";
					} else if (num == 3) {
						listD = "영어";
					} else if (num == 4) {
						listD = "피아노";
					} else if (num == 5) {
						listD = "노래";
					} else if (num == 6) {
						listD = "마술";
					} else if (num == 7) {
						listD = "보건 및 의료";
					} else if (num == 8) {
						listD = "무료법률상담";
					} else if (num == 9) {
						listD = "청소년 상담";
					} else if (num == 10) {
						listD = "JAVA 코딩 교육";
					}

					row_body_donation.innerHTML = listD;

					row_body.appendChild(row_body_name);
					row_body.appendChild(row_body_email);
					// row_body.appendChild(row_body_num);
					row_body.appendChild(row_body_donation);
					talentInDonationBody.appendChild(row_body);
				}
			}
			document.getElementById("talentInBenefit").textContent = ""; // 요청마다 table 초기화

			let talentInBenefit = document.createElement("table");
			let talentInBenefitHead = document.createElement("thead");
			let talentInBenefitBody = document.createElement("tbody");

			talentInBenefit.appendChild(talentInBenefitHead);
			talentInBenefit.appendChild(talentInBenefitBody);

			// js에서 테이블 생성 by #table
			document.getElementById("talentInBenefit").appendChild(talentInBenefit);

			// 테이블 헤더 생성
			let talentInBenefitRow_head = document.createElement("tr");
			let talentInBenefitHead_1 = document.createElement("th");
			talentInBenefitHead_1.innerHTML = "이름";
			let talentInBenefitHead_2 = document.createElement("th");
			talentInBenefitHead_2.innerHTML = "email";
			// let talentInBenefitHead_3 = document.createElement("th");
			// talentInBenefitHead_3.innerHTML = "benefit";
			let talentInBenefitHead_4 = document.createElement("th");
			talentInBenefitHead_4.innerHTML = "수혜 재능";

			talentInBenefitRow_head.appendChild(talentInBenefitHead_1);
			talentInBenefitRow_head.appendChild(talentInBenefitHead_2);
			// talentInBenefitRow_head.appendChild(talentInBenefitHead_3);
			talentInBenefitRow_head.appendChild(talentInBenefitHead_4);
			talentInBenefitHead.appendChild(talentInBenefitRow_head);

			for (index = 0; index < data.length; index++) {
				// if(data[index].benefit == num || data[index].benefit == num) {

				let row_body = document.createElement("tr");
				let row_body_name = document.createElement("td");
				row_body_name.innerHTML = data[index].name;
				let row_body_email = document.createElement("td");
				row_body_email.innerHTML = data[index].email;
				// let row_body_num = document.createElement("td");
				// row_body_num.innerHTML = num;

				if (data[index].benefit == num) {
					let row_body_benefit = document.createElement("td");

					// if(num == null) {
					//     continue
					// }
					let listB;

					if (num == 1) {
						listB = "국어";
					} else if (num == 2) {
						listB = "수학";
					} else if (num == 3) {
						listB = "영어";
					} else if (num == 4) {
						listB = "피아노";
					} else if (num == 5) {
						listB = "노래";
					} else if (num == 6) {
						listB = "마술";
					} else if (num == 7) {
						listB = "보건 및 의료";
					} else if (num == 8) {
						listB = "무료법률상담";
					} else if (num == 9) {
						listB = "청소년 상담";
					} else if (num == 10) {
						listB = "JAVA 코딩 교육";
					}

					row_body_benefit.innerHTML = listB;

					row_body.appendChild(row_body_name);
					row_body.appendChild(row_body_email);
					// row_body.appendChild(row_body_num);
					row_body.appendChild(row_body_benefit);
					talentInBenefitBody.appendChild(row_body);
				}
			}
		});
}
btn.addEventListener("click", printChoice);
btn.addEventListener("click", choiceNum);
