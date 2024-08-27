package com.tinqinacademy.bff.core.converters.comments;

import com.tinqinacademy.bff.api.operations.comments.system.admineditanycomment.AdminEditAnyCommentBFFOutput;
import com.tinqinacademy.comments.api.operations.system.admineditanycomment.AdminEditAnyCommentOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AdminEditAnyCommentOutputToAdminEdintAnyCommentBFFOutput implements Converter<AdminEditAnyCommentOutput, AdminEditAnyCommentBFFOutput> {
    @Override
    public AdminEditAnyCommentBFFOutput convert(AdminEditAnyCommentOutput input) {
        log.info("Start AdminEditAnyCommentOutput to AdminEditAnyCommentBFFOutput input: {}", input);

        AdminEditAnyCommentBFFOutput output = AdminEditAnyCommentBFFOutput.builder()
                .id(input.getId())
                .build();

        log.info("End AdminEditAnyCommentOutput to AdminEditAnyCommentBFFOutput output: {}", output);
        return output;
    }
}
