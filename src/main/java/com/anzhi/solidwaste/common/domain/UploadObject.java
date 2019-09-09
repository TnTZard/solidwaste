package com.anzhi.solidwaste.common.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Map;

/**
 * @author andy
 * @date 2019/7/18 11:11
 */
@ApiModel
@Data
public class UploadObject implements Serializable {


    public UploadObject() {

    }

    @ApiModelProperty(hidden = true)
    protected String path;


    protected Map<String,String> fileInfo;
//    @ApiModelProperty(hidden = true)
//    protected String name;
    //protected String video;

    @ApiModelProperty(value="文件列表",name="files",dataType = "file")
    @TableField(exist = false)
    protected MultipartFile[] files;

    public UploadObject(MultipartFile[] files) {
        this.files = files;
    }
    //    @ApiModelProperty(value="视频列表",name="videoFiles",example="")
//    @TableField(exist = false)
//    protected MultipartFile[] videoFiles;




}
