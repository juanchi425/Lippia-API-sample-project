package api.config;

import services.*;

public enum EntityConfiguration {

    USER {
        @Override
        public Class<?> getEntityService() {
            return UserService.class;
        }

    },
    RESPONSE_HEADERS {
        @Override
        public Class<?> getEntityService() {
            return ResponseHeadersService.class;
        }
    },
    WORKSPACE {
        @Override
        public Class<?> getEntityService() {
            return WorkspaceService.class;
        }
    },
    PROJECT {
        @Override
        public Class<?> getEntityService() {
            return ProjectService.class;
        }
    },
    ERROR {
        @Override
        public Class<?> getEntityService() {
            return ErrorService.class;
        }
    },
    ERROR_404 {
        @Override
        public Class<?> getEntityService() {
            return ErrorService404.class;
        }
    },
    PROJECT_ID {
        @Override
        public Class<?> getEntityService() {
            return ProjectIdService.class;
        }
    },
    UPDATE_PROJECT {
        @Override
        public Class<?> getEntityService() {
            return UpdateProjectService.class;
        }
    },
    ADD_NEW_PROJECT {
        @Override
        public Class<?> getEntityService() {
            return AddNewProjectService.class;
        }
    };



    public abstract Class<?> getEntityService();
}
