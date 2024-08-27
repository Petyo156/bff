package com.tinqinacademy.bff.core.converters.comments;

import com.tinqinacademy.bff.api.operations.comments.system.admineditanycomment.AdminEditAnyCommentBFFInput;
import com.tinqinacademy.bff.api.operations.comments.system.admineditanycomment.AdminEditAnyCommentBFFOutput;
import com.tinqinacademy.comments.api.operations.hotel.leavecommentforroom.LeaveCommentForRoomInput;
import com.tinqinacademy.comments.api.operations.system.admineditanycomment.AdminEditAnyCommentInput;
import com.tinqinacademy.comments.api.operations.system.admineditanycomment.AdminEditAnyCommentOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AdminEditAnyCommentBFFInputToAdminEditAnyCommentInput implements Converter<AdminEditAnyCommentBFFInput, AdminEditAnyCommentInput> {
    @Override
    public AdminEditAnyCommentInput convert(AdminEditAnyCommentBFFInput input) {
        log.info("Start AdminEditAnyCommentBFFInput to AdminEditAnyCommentInput input: {}", input);

        AdminEditAnyCommentInput output = AdminEditAnyCommentInput.builder()
                .commentId(input.getCommentId())
                .content(input.getCommentId())
                .firstName(input.getFirstName())
                .lastName(input.getLastName())
                .roomNo(input.getRoomNo())
                .build();

        log.info("End AdminEditAnyCommentBFFInput to AdminEditAnyCommentInput output: {}", output);
        return output;
    }
}
