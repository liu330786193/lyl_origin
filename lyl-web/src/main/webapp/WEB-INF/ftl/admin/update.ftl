<html>
<head>
    <title>上传图片</title>
</head>
<body>
<form method="post" action="http://192.168.145.48:8066/h5/coupon/upload" enctype="multipart/form-data">

    <div>
        <label>保存图片</label>
        <div >
            <input class="file" type="file" name="bgImage" multiple data-max-file-count="1" data-show-preview="false" data-show-Upload="false"
                   data-allowed-File-Extensions='["gif","GIF","ief","jpeg","jpg","jpe","JPG","tiff","tif","xwd","png"]'>
        </div>
        <div>
            <input type="submit" value="保存">
        </div>
    </div>
</form>
</body>
</html>