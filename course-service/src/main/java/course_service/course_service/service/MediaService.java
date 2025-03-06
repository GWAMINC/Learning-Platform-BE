package course_service.course_service.service;

import com.cloudinary.Cloudinary;
import com.example.media.MediaServiceGrpc;
import com.example.media.MediaRpcProto.*;
import course_service.course_service.repository.MediaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.mock.web.MockMultipartFile;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@Service
public class MediaService extends MediaServiceGrpc.MediaServiceImplBase {

    private final Cloudinary cloudinary;
    private final MediaRepository mediaRepository;

    public MediaService(Cloudinary cloudinary, MediaRepository mediaRepository) {
        this.cloudinary = cloudinary;
        this.mediaRepository = mediaRepository;
    }

    @Override
    public void uploadMedia(UploadMediaRequest request, io.grpc.stub.StreamObserver<UploadMediaResponse> responseObserver) {
        try {
            Map<String, Object> options = new HashMap<>();
            if (request.getType().equals("video")) {
                options.put("resource_type", "video");
            } else if (request.getType().equals("pdf")) {
                options.put("resource_type", "raw");
            }
            // Upload file to Cloudinary
            var uploadResult = cloudinary.uploader().upload(request.getData().toByteArray(), options);
            mediaRepository.createMedia(request.getFileName(),request.getType(),uploadResult.get("url").toString(),uploadResult.get("public_id").toString());

            UploadMediaResponse response = UploadMediaResponse.newBuilder()
                    .setPath(uploadResult.get("url").toString())
                    .setPublicId(uploadResult.get("public_id").toString())
                    .setFileName(request.getFileName())
                    .setType(request.getType())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            System.err.println(e);
            responseObserver.onError(e);
        }
    }

    @Override
    public void getMedia(GetMediaRequest request, io.grpc.stub.StreamObserver<GetMediaResponse> responseObserver) {
        try {
            var media = mediaRepository.findMedia(request.getPublicId());
            if (media.isEmpty()) {
                responseObserver.onError(new Exception("Media not found"));
                return;
            }
            Media media_response = Media.newBuilder()
                    .setFileName(media.get().get("filename").toString())
                    .setType(media.get().get("type").toString())
                    .setPath(media.get().get("path").toString())
                    .setPublicId(media.get().get("public_id").toString())
                    .build();
            GetMediaResponse response = GetMediaResponse.newBuilder()
                    .setMedia(media_response)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            System.err.println(e);
            responseObserver.onError(e);
        }
    }
}