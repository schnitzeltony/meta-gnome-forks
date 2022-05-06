SUMMARY = "A Linux desktop featuring a traditional layout"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=0159e10ccad3751f827b6741af79417b \
"

DEPENDS = " \
    libxml2-native \
    intltool-native \
    cjs \
    muffin \
    cinnamon-menus \
    polkit \
    libsoup-2.4 \
    libnma \
    startup-notification \
    gstreamer1.0-plugins-base \
    libxapp \
"

# gobject-introspection is mandatory and cannot be configured
REQUIRED_DISTRO_FEATURES = "gobject-introspection-data"
GIR_MESON_OPTION = ""

REQUIRED_DISTRO_FEATURES += "x11 polkit"

inherit meson pkgconfig gobject-introspection gtk-icon-cache gsettings gtk-doc gettext features_check

SRC_URI = " \
    git://github.com/linuxmint/cinnamon.git;branch=master;protocol=https \
    file://0001-Do-not-crash-on-systemd-reporting-Univeral-timezone.patch \
    file://okaestne-settings-performance/0001-ExtensionCore-defer-loading-of-cinnamon-version-fix-.patch \
    file://okaestne-settings-performance/0002-cs_privacy-defer-init-of-NM.Client.patch \
    file://okaestne-settings-performance/0003-cs_backgrounds-defer-import-of-imtools-module.patch \
    file://okaestne-settings-performance/0004-Spices-defer-import-of-requests-module.patch \
    file://okaestne-settings-performance/0005-cs-fix-print_timing-remove-stale-touch-function.patch \
    file://okaestne-settings-performance/0006-cs-lazy-load-python-modules-when-passed-as-arg.patch \
    file://polkit-cinnamon-authentication-agent-1.desktop \
"
SRCREV = "037b17248b176c7f3dd5c9848f8c6738105c4cc2"
PV = "5.2.7+git${SRCPV}"
S = "${WORKDIR}/git"

do_install:append() {
    install -d ${D}${sysconfdir}/xdg/autostart
    install -m644 ${WORKDIR}/polkit-cinnamon-authentication-agent-1.desktop ${D}${sysconfdir}/xdg/autostart
}

FILES:${PN} += " \
    ${datadir}/cinnamon-session \
    ${datadir}/dbus-1 \
    ${datadir}/desktop-directories \
    ${datadir}/polkit-1 \
    ${datadir}/xsessions \
"

RDEPENDS:${PN} += " \
    bash \
    network-manager-applet \
    cinnamon-control-center \
    cinnamon-menus \
    cinnamon-screensaver \
    cinnamon-settings-daemon \
    nemo \
    evolution-data-server \
    libtimezonemap \
    tzdata \
    gettext \
    keybinder \
    metacity \
    gnome-panel \
    polkit-gnome \
    wget \
    cups \
    accountsservice \
    python3-core \
    python3-distro \
    python3-dbus \
    python3-lxml \
    python3-pam \
    python3-pillow \
    python3-pexpect \
    python3-psutil \
    python3-pycairo \
    python3-pygobject \
    python3-pyinotify \
    python3-pytz \
    python3-requests \
    python3-setproctitle \
    python3-simplejson \
    python3-syslog \
    python3-tinycss2 \
    python3-xapp \
"

PACKAGES += "${PN}-python"
FILES:${PN}-python += "${PYTHON_SITEPACKAGES_DIR}"
