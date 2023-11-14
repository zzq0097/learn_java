package com.zzq.learn.file;

import cn.hutool.core.lang.Assert;
import com.zzq.learn.model.result.R;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UploadController {
    private final MinioClient minioClient;

    @Value("${minio.app_bucket}")
    private String appBucket;

    @PostMapping("upload")
    public R<?> upload(MultipartFile file) {
        file.getContentType();
        Assert.notNull(file, "");
        Assert.isTrue(!file.isEmpty(), "");
        try {
            minioClient.putObject(PutObjectArgs.builder()
                    .bucket(appBucket)
                    .object(file.getOriginalFilename())
                    .contentType(file.getContentType())
                    .stream(file.getInputStream(), file.getSize(), -1)
                    .build());
        } catch (Exception e) {
            log.error(e.getMessage());
            return R.fail(e.getMessage());
        }
        return R.ok();
    }
}
