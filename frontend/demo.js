
$(document).ready(function(){
    //khi load trang no se tai trang home
    // navUse();
    // navDeparment();
});

function navUse(){
    console.log("chuyen sang trang user")
    $('#main').load("./user.html");
    getListUser();
}


function navHome(){
    console.log("chuyen sang trang navHome")
    $('#main').load("./home.html");
}

function getListUser(){
    $.ajax({
        url:"http://localhost:8686/api/v1/user/users",
        type:"GET",
        contentType:"application/json",
        error: function(err){
            console.log(err);
        },
        success: function(data){
            fillDateToUserTable(data);
            console.log(data);
        },
    });
}

function findeUser(){
    let username = document.getElementById("input-username").value;
    let object = {
        "name" : username,
        page: 1,
        size: 3
    }
    console.log(object);
    $.ajax({
        url: "http://localhost:8686/api/v1/user/search",
        type: "Post",
        data: JSON.stringify(object),
        // beforeSend: function (xhr) {
        //     xhr.setRequestHeader('Authorization', 'Bearer ' + localStorage.getItem("token"));
        // },
        contentType: "application/json",
        error: function (err) {
            alert(err)
        },
        success: function (data) {
            showDataSearch(data);
            console.log(data);
        }
    });
}

function showDataSearch(data){
    fillDateToUserTable(data.content);
}

function fillDateToUserTable(data){
    $('#tbodyUser').empty();
    let i = 0;
    data.forEach(element => {
        i++;
        $('#tbodyUser').append(
            `<tr>
            <th scope="row">${i}</th>
            <td>
                <img style ="height: 80px" src=${element.avatar} class= "rounded" alt="Anh dai dien">
            </td>
            <td>${element.name}</td>
            <td>${element.email}</td>
            <td>${element.dob}</td>
            <td>
                <i class='fa fa-pencil mr-2' style="font-size:24px; color : orange; cursor:pointer">
                </i>
                <i class='fa fa-trash' style="font-size:24px; color:red; cursor:pointer" 
                    onclick="deleteUser(${element.id},'${element.name}')">
                </i>
            </td>
          </tr>
          `
        )
    });
}

function deleteUser(id, userName){
    $('#exampleModal').modal('show')
    document.getElementById("userName-delete").innerHTML = userName;
    document.getElementById("id-delete").value = id;
    // document.getElementById("userName-delete").innerHTML = userName;
    // document.getElementById("id-delete").value = id;
    // if(confirm("ban co muon xoa " + userName + " khong?")){

    // }
}

function onDelete() {
    // lấy được giá trij ID muốn xoá
    let id = document.getElementById("id-delete").value;

    // Call API
    $.ajax({
        url: "http://localhost:8686/api/v1/user/delete/" + id,
        type: "DELETE",
        // beforeSend: function (xhr) {
        //     xhr.setRequestHeader('Authorization', 'Bearer ' + localStorage.getItem("token"));
        // },
        contentType: "application/json",
        error: function (err) {
            alert(err)
        },
        success: function (data) {
            alert("Đã xoá thành công")
            getListUser()
        }
    });
    $('#exampleModal').modal('hide')
}

function openModal(){
    $('#exampleModalForm').modal('show')

    document.getElementById("input-Name").value = "";
    document.getElementById("input-email").value = "";
    document.getElementById("input-datOfBirth").value = "";
    document.getElementById("input-avatar").value = "";
}

function onSave(){
   let userName =  document.getElementById("input-Name").value;
   let email = document.getElementById("input-email").value;
   let dob =  document.getElementById("input-datOfBirth").value;
   let avatar =  document.getElementById("input-avatar").value;
   let object = {
    "name": userName,
    "avatar": avatar,
    "email": email,
    "dob": dob
   };
   console.log(object);
   $.ajax({
    url: "http://localhost:8686/api/v1/user/create",
    type: "Post",
    data: JSON.stringify(object),
    // beforeSend: function (xhr) {
    //     xhr.setRequestHeader('Authorization', 'Bearer ' + localStorage.getItem("token"));
    // },
    contentType: "application/json",
    error: function (err) {
        alert(err)
    },
    success: function (data) {
        $('#exampleModalForm').modal('hide')
        alert("Đã thêm thành công")
        
        getListUser()
    }
});
}