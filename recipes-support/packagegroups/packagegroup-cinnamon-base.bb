SUMMARY = "Basic Cinnamon desktop session"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# at least cinnamon-menus are dynamically renamed
PACKAGE_ARCH = "${TUNE_PKGARCH}"

inherit packagegroup

RDEPENDS:${PN} = " \
    mint-backgrounds-una \
    mint-themes \
    mint-x-icons \
    mint-y-icons \
    cinnamon \
    cinnamon-control-center \
    cinnamon-default-config \
    cinnamon-desktop \
    cinnamon-menus \
    cinnamon-screensaver \
    cinnamon-session \
    cinnamon-settings-daemon \
    cjs \
    muffin \
    nemo \
    python3-xapp \
    libxapp \
    adwaita-icon-theme \
"
