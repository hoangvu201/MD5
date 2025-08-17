package ra.edu.btvn01.dto;

import jakarta.validation.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public class PostDTO {
    @NotBlank(message = "Nội dung không được để trống")
    private String content;

    private MultipartFile image;

    public PostDTO() {
    }

    public PostDTO(String content, MultipartFile image) {
        this.content = content;
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
