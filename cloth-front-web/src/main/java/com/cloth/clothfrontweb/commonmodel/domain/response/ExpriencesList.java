package com.cloth.clothfrontweb.commonmodel.domain.response;

import com.cloth.clothfrontweb.commonmodel.domain.Designer;
import com.cloth.clothfrontweb.commonmodel.domain.Expriences;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExpriencesList {
    private String surface;
    private String surfaceIntroduce;
    private String surfaceTopic;
    private String comment;
    private String text;
    private String blackTopic;
    private String picture;
    private String textType;
    private String designerType;
    public ExpriencesList(Designer designer, Expriences expriences){
        this.surface=designer.getSurface();
        this.surfaceTopic = designer.getSurfaceTopic();
        this.surfaceIntroduce = designer.getSurfaceIntroduce();
        this.comment=designer.getComment();
        this.picture = expriences.getPicture();
        this.blackTopic = expriences.getBlackTopic();
        this.text = expriences.getText();
        this.textType=expriences.getType();
        this.designerType=designer.getType();
    }
}
