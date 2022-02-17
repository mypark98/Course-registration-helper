/*
 * 
 */


function chkValue(){
	if(document.frm.id.value == ''){
		alert('교과목 코드를 작성해주세요!');
		document.frm.id.focus();
		return false;
	}
	if(document.frm.name.value == ''){
		alert('교과목명을 작성해주세요!');
		document.frm.name.focus();
		return false;
	}
	if(document.frm.credit.value == ''){
		alert('교과목명을 작성해주세요!');
		document.frm.credit.focus();
		return false;
	}
	if((document.frm.lecturer.value == '') ||(document.frm.lecturer.value == '담당강사선택')){
		alert('담당강사를 작성해주세요!');
		document.frm.lecturer.focus();
		return false;
	}
	if(document.frm.week.value == ''){
		alert('요일을 작성해주세요!');
		document.frm.week.focus();
		return false;
	}
	if(document.frm.start_hour.value == ''){
		alert('시작시간을 작성해주세요!');
		document.frm.start_hour.focus();
		return false;
	}
	if(document.frm.end_end.value == ''){
		alert('종료시간을 작성해주세요!');
		document.frm.end_end.focus();
		return false;
	}
	
	return true;
}