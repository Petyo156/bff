package com.tinqinacademy.bff.core.converters.comments;

import com.tinqinacademy.bff.api.operations.comments.system.admindeleteanycomment.AdminDeleteAnyCommentBFFInput;
import com.tinqinacademy.comments.api.operations.hotel.leavecommentforroom.LeaveCommentForRoomInput;
import com.tinqinacademy.comments.api.operations.system.admindeleteanycomment.AdminDeleteAnyCommentInput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AdminDeleteAnyCommentBFFInputToAdminDeleteAnyCommentInput implements Converter<AdminDeleteAnyCommentBFFInput, AdminDeleteAnyCommentInput> {
    @Override
    public AdminDeleteAnyCommentInput convert(AdminDeleteAnyCommentBFFInput input) {
        log.info("Start AdminDeleteAnyCommentBFFInput to AdminDeleteAnyCommentInput input: {}", input);

        AdminDeleteAnyCommentInput output = AdminDeleteAnyCommentInput.builder()
                .commentId(input.getCommentId())
                .build();

        log.info("End AdminDeleteAnyCommentBFFInput to AdminDeleteAnyCommentInput output: {}", output);
        return output;
    }
}
