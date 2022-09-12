package com.zzq.learn.file;

import cn.hutool.core.lang.Assert;
import com.zzq.learn.config.bean.MinioConfig;
import com.zzq.learn.model.result.R;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UploadController {
    private final MinioConfig minioConfig;
    private final MinioClient minioClient;

    @PostMapping("upload")
    public R<?> upload(MultipartFile file) {
        file.getContentType();
        Assert.notNull(file, "");
        Assert.isTrue(!file.isEmpty(), "");
        try {
            minioClient.putObject(PutObjectArgs.builder()
                    .bucket(minioConfig.getAppBucket())
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
