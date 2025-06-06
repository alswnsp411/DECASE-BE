package com.skala.decase.domain.project.mapper;

import com.skala.decase.domain.project.controller.dto.response.DeleteMemberResponse;
import com.skala.decase.domain.project.controller.dto.response.MemberInvitationResponse;
import com.skala.decase.domain.project.controller.dto.response.MemberProjectResponse;
import com.skala.decase.domain.project.domain.MemberProject;
import com.skala.decase.domain.project.domain.ProjectInvitation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProjectMemberMapper {

    public MemberProjectResponse toResponse(MemberProject memberProject) {
        return new MemberProjectResponse(
                memberProject.getMember().getMemberId(),
                memberProject.getMember().getId(),
                memberProject.getMember().getName(),
                memberProject.getMember().getCompany().getName(),
                memberProject.getMember().getCompany().getName(),
                memberProject.getPermission()
        );
    }

    public DeleteMemberResponse deleteSuccess() {
        return new DeleteMemberResponse("멤버가 정상적으로 삭제되었습니다.");
    }

    public MemberInvitationResponse toInvite(ProjectInvitation projectInvitation) {
        return new MemberInvitationResponse(
                projectInvitation.getEmail(),
                projectInvitation.isAccepted(),
                projectInvitation.getPermission()
        );
    }
}
