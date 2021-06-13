/**
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
*      FILE NAME : script-utils.js
* REPORTING DATE : 2020.01.10
*     WRITTEN BY : zinzoddari@gmail.com
=====================================================
* REVISION HISTORY
 -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --*/

/**
 * id로 DOM get
 */
function getElementId(objId) {
	return document.getElementById(objId);
}

/**
 * 값 length CHECK
 */
function equalLength(obj, length) {
	if(obj.length == length) {
		return true;
	}
	return false;
}

/**
 * 값 > length CHECK
 */
function isOverLength(obj, length) {
	if(obj.length > length) {
		return true;
	}
	return false;
}

/**
 * 값이 NULL인지 CHECK
 */
function isNull(obj) {
	if(obj.value == null || obj.value == "") {
		return true;
	}
	else return false;
}

/**
 * 값이 NULL이 아니면 false 반환
 */
function isNotNull(obj) {
	if(obj.value != null || obj.value != "") {
		return false;
	}
	else return true;
}

/**
 * 숫자값에 콤마 출력
 */
function numberWithComma(obj) {
	return obj.toString().replace(/\B(?=(\d{3})+(?!\d)/g, ",");
}

/**
 * 페이지 이동
 */
function goPageMove(url) {
	location.href = url;
}

/**
 * form Submit
 */
function formSubmit(action, formObj, method) {
	formObj.method = method;
	formObj.action = action;
	
	formObj.submit();

}

/**
 * Ajax Submit
 */
function requestAjax(action, formObj, method, async, callback) {
	var xhr = new XMLHttpRequest();

	var formData = formToFormData(formObj);

	xhr.onreadystatechange = function() {
    	if (xhr.readyState === 4) {
    		if (xhr.status === 200) {
    			if(xhr.response != null) {
    				if(callback != null) {
    					callback(JSON.parse(xhr.response));
    				}
    			}
    		}
    	}
    };

    xhr.open(method, action, async);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send(formData);
}

/**
 * 
 * @param action
 * @param formObj
 * @param callback
 * @returns
 */
function actionFetch(url, method, formObj, callback) {
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	
	var headers = new Headers();
	headers.append('Content-Type', 'application/json; charset=UTF-8');
	headers.append(header, token);
	
	fetch(url, {
		method: method,
		body : JSON.stringify(formObj),
		headers
		})
		.then((response) => {
			if (response.status === 200 || response.status === 201) {
				response.json().then((response) => { if(callback != null) callback(response) });
			} 
			else {
				console.error(response.statusText);
			}
		})
		.catch((e) => error(e));
}	

function validateAjax(action, formObj, callback) {
	var result = false;
	
	requstAjax(action, formObj, 'post', false, result = function(data) {
		result = data;
	});
	
	return result;
}

/**
 * formObject to FormData
 */
function formToFormData(formObj) {
	var formData = new FormData(formObj);
    var formDataObj = {};

    for(var key of formData.keys()) {
    	var data = formData.get(key);
    	formDataObj[key] = (data !== undefined ? data : '');
    }

    return JSON.stringify(formDataObj);

}