
function navDeparment(){
    console.log("chuyen sang trang navDeparment")
    $('#main').load("./department.html");
    getListdepartment();
}

function getListdepartment(){
    $.ajax({
        url:"http://localhost:8686/api/v1/department/departments",
        type:"GET",
        contentType:"application/json",
        error: function(err){
            console.log(err);
        },
        success: function(data){
            fillDateToTable(data);
            console.log(data);
        },
    });
}

function fillDateToTable(data){
    $('#tbodyDepartment').empty();
    let i = 0;
    data.forEach(element => {
        i++;
        $('#tbodyDepartment').append(
            `<tr>
            <th scope="row">${i}</th>
            <td>${element.departmentName}</td>
            <td>${element.numbers}</td>
            <td>
                <i class='fa fa-pencil mr-2' style="font-size:24px; color : orange; cursor:pointer">
                </i>
                <i class='fa fa-trash' style="font-size:24px; color:red; cursor:pointer" 
                    onclick="deleteDepartment(${i},'${element.departmentName}')">
                </i>
            </td>
            </tr>
          `
        )
    });
}

function deleteDepartment(id, departmentName){
    $('#exampleModalDelDepart').modal('show');
    document.getElementById("id-Departmentdelete").value = id;
    document.getElementById("departmentName-delete").innerHTML = departmentName;
}

function onDeleteDepartment() {
    // lấy được giá trij ID muốn xoá
    let id = document.getElementById("id-Departmentdelete").value;

    // Call API
    $.ajax({
        url: "http://localhost:8686/api/v1/department/delete/" + id,
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
            getListdepartment()
        }
    });
    $('#exampleModalDelDepart').modal('hide')
}

function openModalDepartment(){
    $('#exampleModalAddDepartment').modal('show')

    document.getElementById("input-departmentname").value = "";
    document.getElementById("input-departmentnumber").value = "";
}

function onSaveDepartment(){
   let name =  document.getElementById("input-departmentname").value;
   let number = document.getElementById("input-departmentnumber").value;
   let object = {
    "departmentName": name,
    "numbers": number
   };
   console.log(object);
   $.ajax({
    url: "http://localhost:8686/api/v1/department/create",
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
        
        getListdepartment()
    }
});
}