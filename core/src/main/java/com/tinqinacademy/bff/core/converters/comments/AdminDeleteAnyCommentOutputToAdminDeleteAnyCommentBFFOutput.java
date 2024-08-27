package com.tinqinacademy.bff.core.converters.comments;

import com.tinqinacademy.bff.api.operations.comments.system.admindeleteanycomment.AdminDeleteAnyCommentBFFOutput;
import com.tinqinacademy.comments.api.operations.system.admindeleteanycomment.AdminDeleteAnyCommentOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AdminDeleteAnyCommentOutputToAdminDeleteAnyCommentBFFOutput implements Converter<AdminDeleteAnyCommentOutput, AdminDeleteAnyCommentBFFOutput> {
    @Override
    public AdminDeleteAnyCommentBFFOutput convert(AdminDeleteAnyCommentOutput input) {
        log.info("Start AdminDeleteAnyCommentOutput to AdminDeleteAnyCommentBFFOutput input: {}", input);

        AdminDeleteAnyCommentBFFOutput output = AdminDeleteAnyCommentBFFOutput.builder()
                        .build();

        log.info("End AdminDeleteAnyCommentOutput to AdminDeleteAnyCommentBFFOutput output: {}", output);
        return output;
    }
}
