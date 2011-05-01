function f_user() {
    f_handleImgAddUser();
    f_showList();
}

function f_handleImgAddUser() {
    $("#imgAddUser").click(function () {
        f_addUser();
    });
}

function f_showList() {
    $("#tblUsers tbody").empty();
    $.ajax({
        url:"rest/users",
        type: "GET",
        dataType: "json",
        success: function (backData, status, xhr) {
            f_loadUserListTpl(backData.response.userDTO);
        },
        error: function (xhr, status, ex) {
        },
        complete: function (xhr, status) {
        }
    });
}

function f_loadUserListTpl(dataList) {
    $.ajax({
        url: '/web/template/user/userList.tpl',
        data: '',
        dataType: 'text',
        success: function (templateText) {
            $.tmpl(templateText, dataList).appendTo("#tblUsers");
        }
    });
}

function f_addUser() {
    $("#userDialog").remove();
    $("#mainUsers").append("<div id=\"userDialog\"></div>");
    $("#userDialog").dialog({
        bgiframe: true,
        autoOpen: false,
        height: 200,
        width: 550,
        modal: true,
        resizable: false,
        draggable: true,
        closeOnEscape: true,
        title: "Add new user",
        zIndex: 2000,
        close: function() {
            $("#userDialog").remove();
        }
    });
    $("#userDialog").load("/web/fragment/user/edit.html");
    $("#userDialog").dialog("open");
}

function f_saveUser() {
    $.ajax({
        url: "/web/rest/users/user",
        type: "POST",
        dataType: "json",
        contentType: 'application/x-www-form-urlencoded; charset=iso-8859-1;',
        data: $("#userForm").serialize(),
        success: function (backData, status, xhr) {
            $("#userDialog").dialog("close");
            f_showUsers();
        },
        error: function (xhr, status, ex) {
        },
        complete: function (xhr, status) {
        }
    });
}

function f_viewUser(userId) {
    $("#userDialog").remove();
    $("#mainUsers").append("<div id=\"userDialog\"></div>");
    $("#userDialog").dialog({
        bgiframe: true,
        autoOpen: false,
        height: 200,
        width: 550,
        modal: true,
        resizable: false,
        draggable: true,
        closeOnEscape: true,
        title: "User information",
        zIndex: 2000,
        close: function() {
            $("#userDialog").remove();
        }
    });
    $.ajax({
        url:"/web/rest/users/" + userId,
        type: "GET",
        success: function (backData, status, xhr) {
            $("#userDialog").load("/web/template/user/view.tpl", function(template) {
                $.tmpl(template, backData).appendTo(this);
            });
        },
        error: function (xhr, status, ex) {
        },
        complete: function (xhr, status) {
        }
    });
    $("#userDialog").dialog("open");
}

function f_updateUser() {
    $.ajax({
        url: "/web/rest/users/user",
        type: "PUT",
        dataType: "json",
        contentType: 'application/x-www-form-urlencoded; charset=iso-8859-1;',
        data: $("#userForm").serialize(),
        success: function (backData, status, xhr) {
            $("#userDialog").dialog("close");
            f_showUsers();
        },
        error: function (xhr, status, ex) {
        },
        complete: function (xhr, status) {
        }
    });
}

function f_deleteUser(userId) {
    $.ajax({
        url: "/web/rest/users/" + userId,
        type: "DELETE",
        dataType: "json",
        contentType: 'application/x-www-form-urlencoded; charset=iso-8859-1;',
        success: function (backData, status, xhr) {
        },
        error: function (xhr, status, ex) {
        },
        complete: function (xhr, status) {
            f_showUsers();
        }
    });
}