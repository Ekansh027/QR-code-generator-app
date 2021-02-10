package com.goyal.ekansh.springbootqrcodeapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QrCodeController {
    private static final String QR_CODE_IMAGE_PATH= "./src/main/resources/QrCode.png";

    @GetMapping(value= "/generateAndDownloadQrCode/{codeText}/{width}/{height}")
    public void download(

        @PathVariable("codeText") String codeText,
        @PathVariable("width") Integer width,
        @PathVariable("height") Integer height )
 throws Exception{
     QrCodeGenerator.generateQrCodeImage(codeText,width,height,QR_CODE_IMAGE_PATH);

        }

    @GetMapping(value= "/generateQrCode/{codeText}/{width}/{height}")
    public ResponseEntity<byte[]> generateQrCOde(

            @PathVariable("codeText") String codeText,
            @PathVariable("width") Integer width,
            @PathVariable("height") Integer height )
            throws Exception{

        return ResponseEntity.status(HttpStatus.OK).body(QrCodeGenerator.getQrCodeImage(codeText,width,height));

    }


}
