package com.youtube.shortsuploader.shortscontent.domain;

public enum ContentStatus {
    READY_TO_GENERATE("생성 대기", "모든 정보가 입력되어 동영상 생성 가능한 상태"),
    GENERATING("동영상 생성 중", "시스템에서 동영상을 생성하고 있는 상태"),
    GENERATION_FAILED("생성 실패", "동영상 생성 중 오류가 발생한 상태"),
    READY_TO_UPLOAD("업로드 대기", "동영상 생성 완료되어 유튜브 업로드 가능한 상태"),
    UPLOADING("업로드 중", "유튜브에 업로드하고 있는 상태"),
    UPLOAD_FAILED("업로드 실패", "유튜브 업로드 중 오류가 발생한 상태"),
    COMPLETED("완료", "유튜브 업로드까지 모든 과정이 완료된 상태");

    private final String displayName;
    private final String description;

    ContentStatus(String displayName, String description) {
        this.displayName = displayName;
        this.description = description;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getDescription() {
        return description;
    }

    // 비즈니스 로직 메서드들
    public boolean canGenerateVideo() {
        return this == READY_TO_GENERATE || this == GENERATION_FAILED;
    }

    public boolean canUploadToYouTube() {
        return this == READY_TO_UPLOAD || this == UPLOAD_FAILED;
    }

    public boolean isInProgress() {
        return this == GENERATING || this == UPLOADING;
    }

    public boolean isCompleted() {
        return this == COMPLETED;
    }

    public boolean hasError() {
        return this == GENERATION_FAILED || this == UPLOAD_FAILED;
    }

    // 상태 전환 가능 여부 체크
    public boolean canTransitionTo(ContentStatus newStatus) {
        return switch (this) {
            case READY_TO_GENERATE -> newStatus == GENERATING;
            case GENERATING -> newStatus == READY_TO_UPLOAD || newStatus == GENERATION_FAILED;
            case GENERATION_FAILED -> newStatus == GENERATING;
            case READY_TO_UPLOAD -> newStatus == UPLOADING;
            case UPLOADING -> newStatus == COMPLETED || newStatus == UPLOAD_FAILED;
            case UPLOAD_FAILED -> newStatus == UPLOADING;
            case COMPLETED -> false; // 완료 상태에서는 다른 상태로 전환 불가
            default -> false;
        };
    }
}
