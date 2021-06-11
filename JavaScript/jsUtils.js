let token = window.sessionStorage.getItem('token');

function getErrorDiv()	{
	const errorDiv = document.createElement("div");
	const errorContent = document.createTextNode("Error in credentials");
	errorDiv.appendChild(errorContent);
	errorDiv.style.color = "RED";
	return errorDiv;
}

function display(path, objectClass) {
	fetch('http://localhost:8080/StreamingVideoBE' + path, {
		method: 'GET',
		headers: {
			'Content-type': 'application/json; charset=UTF-8',
			'Authorization': 'Bearer ' + token
		},
	})
	.then((response) => response.json())
	.then(json => render(json, objectClass));
}

function render(json, objectClass) {
	json.map(object => {
		// object div
		let objectDiv = document.createElement("div");
		objectDiv.id = object.title;
		objectDiv.className = objectClass;
		document.body.insertAdjacentElement('beforeend', objectDiv);
		
		// object title
		let titleDiv = document.createElement("div");
		let titleContent = document.createTextNode(object.title);
		titleDiv.id = object.title + 'Title';
		titleDiv.className = 'title';
		titleDiv.appendChild(titleContent);
		titleDiv.onclick = function() {
			window.localStorage.setItem('' + objectClass + 'Id', object.id);
			window.location.href = getNextPage(objectClass);
		};
		objectDiv.insertAdjacentElement('beforeend', titleDiv);
		
		// object description
		let descriptionDiv = document.createElement("div");
		let descriptionContent = document.createTextNode(object.description);
		descriptionDiv.id = object.title + 'Desc';
		descriptionDiv.className = 'description';
		descriptionDiv.appendChild(descriptionContent);
		descriptionDiv.style.display = 'none';
		objectDiv.insertAdjacentElement('beforeend', descriptionDiv);
		
		objectDiv.onmouseover = function() {descriptionDiv.style.display = 'block';};
		objectDiv.onmouseout = function() {descriptionDiv.style.display = 'none';};
	});
}

function getNextPage(objectClass) {
	switch (objectClass) {
		case 'category':
			return 'subcat.html';
		break;
		case 'subcategory':
			return 'video.html';
		break;
		case 'video':
			return 'tag.html';
		break;
	}
}

function displayTags() {
	fetch('http://localhost:8080/StreamingVideoBE/video/' + videoId + '/tags', {
		method: 'GET',
		headers: {
			'Content-type': 'application/json; charset=UTF-8',
			'Authorization': 'Bearer ' + token
		},
	})
	.then((response) => response.json())
	.then(json => renderTags(json));
}

function renderTags(json) {
	json.map(tag => {
		// tag
		const tagDiv = document.createElement("div");
		tagDiv.id = tag;
		tagDiv.className = 'tag';
		document.body.insertAdjacentElement('beforeend', tagDiv);
		
		// tag title
		let titleDiv = document.createElement("div");
		let titleContent = document.createTextNode(tag);
		titleDiv.id = tag + 'Title';
		titleDiv.className = 'title';
		titleDiv.appendChild(titleContent);
		tagDiv.insertAdjacentElement('beforeend', titleDiv);
	});
}