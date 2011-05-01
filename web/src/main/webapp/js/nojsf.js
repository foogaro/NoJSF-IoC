function f_loadReource(uriHTML, uriJS, element, callback) {
    if (uriJS != '' || uriJS != null) {
        f_loadScript(uriHTML, uriJS, element, callback);
    } else {
        f_loadFragment(uriHTML, element, callback);
    }
}

function f_loadScript(uriHTML, uriJS, element, callback) {
    $.getScript(uriJS, function () {
        f_loadFragment(uriHTML, element, callback);
    });
}

function f_loadFragment(uriHTML, element, callback) {
    $.get(uriHTML, function (fragment) {
        $(element).empty();
        $(element).append(fragment);
        if (callback != '' || callback != null) {
            eval(callback).call();
        }
    });
}
