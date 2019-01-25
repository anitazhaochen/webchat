<!DOCTYPE html>
<!-- saved from url=(0022)http://localhost:8080/ -->
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <meta name="viewport" content="width=device-width">
    <title>Chat Room</title>
<link rel="shortcut icon" href="http://localhost:8080/favicon.ico"><style type="text/css">* {
    margin: 0;
    padding: 0;
    font-family: Roboto;
}
html,body {
    height: 100%;
}
.cursor-forbid {
    cursor: not-allowed;
}
.container {
    width: 100%;
    height: calc(100% - 100px);
    background-color: #ececec;
    padding-top: 100px;
}
.chat-room {
    width: 80%;
    max-width: 800px;
    height: 600px;
    margin-left: auto;
    margin-right: auto;
    background-color: #ebebeb;
    border-radius: 5px;
    border: 2px solid #8a8a8a;
}
.send-to {
    float: right;
    width: 200px;
    height: calc(100% - 20px);
    margin: 10px;
    border-radius: 3px;
    border: 2px solid #8a8a8a;
    background-color: #ebebeb;
}
.send-to h2 {
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
    font-size: 24px;
    height: 40px;
    line-height: 40px;
    text-align: center;
    background-color: #ebebeb;
    border-bottom: 1px solid #888;
}
.contact-list {
    list-style: none;
}
.contact-list-item {
    height: 30px;
    line-height: 30px;
    text-align: center;
    border-bottom: 1px solid #888;
    cursor: pointer;
    transition: all 300ms;
}
.contact-list-item.is-active {
    background-color: #9E9E9E;
}
.contact-name {
    display: inline-block;
    width: 120px;
    color: #555;
    text-align: left;

    word-wrap: break-word;
    white-space: nowrap;
    text-overflow: ellipsis;
    overflow: hidden;
}
.contact-name:hover {
    color: #333;
    text-decoration: underline;
}
.conversation {
    height: calc(100% - 20px);
    margin: 10px;
    overflow: hidden;
    border: 2px solid #323232;
    border-radius: 3px;
}
.header {
    height: 40px;
    line-height: 40px;
    border-bottom: 1px solid #888;
    padding-left: 20px;
}
.header input {
    margin-left: 5px;
    height: 20px;
    line-height: 20px;
    outline: none;
    padding: 3px;
    transition: all 150ms linear;
    border: 1px solid transparent;
    -webkit-border-radius: 3px;
    -moz-border-radius: 3px;
    border-radius: 3px;
    background-color: #ebebeb;
}
.header input:focus {
    border-color: #589ffb;
    background-color: #fff;
}
.dialog-content {
    padding: 5px 8px;
    height: 350px;
    overflow-y: scroll;
    border-bottom: 2px solid #8a8a8a;
}
.dialog-toolbox {
    height: 40px;
    line-height: 40px;
    padding-left: 10px;
    border-bottom: 1px solid #8a8a8a;
}
.dialog-input {
    height: 100px;
}
.dialog-input label {
    display: none;
}
.dialog-input textarea {
    width: calc(100% - 16px);
    height: calc(100% - 10px);
    outline: none;
    resize: none;
    padding: 5px 8px;
    font-size: 16px;
    background-color: #fff;
    transition: all 150ms linear;
    border: none;
}
.dialog-footer {
    height: 36px;
    background-color: #fff;
}
.copyright {
    display: inline-block;
    padding-left: 3px;
    padding-top: 16px;
}
.copyright>small {
    font-size: 12px;
    color: #aaa;
}
.btn-group {
    float: right;
    display: inline-block;
    height: 36px;
    line-height: 36px;
    padding-right: 6px;
}
.btn-send {
    width: 60px;
    height: 28px;
    outline: none;
    border-radius: 3px;
    border: 1px solid #999;
    text-align: center;
    transition: all 150ms linear;
}
.btn-send:hover {
    color: #333;
    border-color: #333;
    background-color: #ccc;
}
.record-item {
    cursor: default;
}
.record-label {
    font-size: 12px;
    line-height: 20px;
}
.record-text {
    font-size: 16px;
    color: #555;
    line-height: 26px;
    text-indent: 4px;
}
.color-deep-blue {
    color: #0000ff;
}
.color-blue {
    color: #0d83cb;
}</style>
</head>
<body>
<div class="container">
    <div class="chat-room">
        <div class="send-to">
            <h2>Send To</h2>
            <ul id="contact" class="contact-list"></ul>
        </div>
        <div class="conversation">
            <div class="header">
                <label for="nickname">Name:</label>
                <label id="nickname" type="text">${username}</label>
            </div>
            <div class="dialog">
                <div id="content" class="dialog-content"></div>
                <div class="dialog-toolbox">
                    <button class="btn-express cursor-forbid">☺</button>
                </div>
                <div class="dialog-input">
                    <label for="msg"></label>
                    <textarea id="msg"></textarea>
                </div>
                <div class="dialog-footer">
                    <div class="copyright">
                        <small>email - lonelydawn@sina.com</small>
                    </div>
                    <div class="btn-group">
                        <button id="send" class="btn-send">Send</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="js/bundle.js"></script>
<div id="jlzsCpn_0_component_0" class=" jlzs-container jlzs-gate" style="width: auto; height: 868px;"></div>
</body>
</html>