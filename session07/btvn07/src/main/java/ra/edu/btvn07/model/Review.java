package ra.edu.btvn07.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @NotBlank(message = "Tên không được để trống")
    private String username;
    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không hợp lệ")
    private String email;
    @NotNull(message = "Đánh giá không được để trống")
    @Min(value = 1,message = "Đánh giá tối thiểu là 1 sao")
    @Max(value = 5,message = "Đánh giá tối đa là 5 sao")
    private int rating;
    @Size(max = 200,message = "Bình luận không được vượt quá 200 ký tự")
    @NotBlank(message = "Bình luận không được để trống")
    private String comment;
}
