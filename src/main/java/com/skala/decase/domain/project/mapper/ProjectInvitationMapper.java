package com.skala.decase.domain.project.mapper;

import com.skala.decase.domain.member.domain.Member;
import com.skala.decase.domain.project.controller.dto.response.DeleteMemberResponse;
import com.skala.decase.domain.project.controller.dto.response.InvitationInfoResponse;
import com.skala.decase.domain.project.controller.dto.response.MemberInvitationResponse;
import com.skala.decase.domain.project.controller.dto.response.MemberProjectResponse;
import com.skala.decase.domain.project.domain.MemberProject;
import com.skala.decase.domain.project.domain.Project;
import com.skala.decase.domain.project.domain.ProjectInvitation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProjectInvitationMapper {

    public MemberProjectResponse toResponse(MemberProject memberProject) {
        return new MemberProjectResponse(
                memberProject.getMember().getMemberId(),
                memberProject.getMember().getId(),
                memberProject.getMember().getName(),
                memberProject.getMember().getCompany().getName(),
                memberProject.getMember().getCompany().getName(),
                memberProject.getPermission(),
                memberProject.isAdmin()
        );
    }

    public DeleteMemberResponse deleteSuccess() {
        return new DeleteMemberResponse("멤버가 정상적으로 삭제되었습니다.");
    }

    public DeleteMemberResponse deleteInvitationSuccess() {
        return new DeleteMemberResponse("초대가 정상적으로 삭제되었습니다.");
    }

    public MemberInvitationResponse toInvite(ProjectInvitation projectInvitation) {
        return new MemberInvitationResponse(
                projectInvitation.getEmail(),
                projectInvitation.isAccepted(),
                projectInvitation.getPermission()
        );
    }

    public InvitationInfoResponse toInviteResponse(Project project, Member admin) {
        return new InvitationInfoResponse(
                project.getProjectId(),
                project.getName(),
                admin.getName()
        );
    }
}
