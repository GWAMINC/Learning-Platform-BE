package course_service.course_service.service;

import com.example.gatewaycoupon.CouponServiceGrpc;
import com.example.gatewaycoupon.GateWayCouponRpcProto.*;
import course_service.course_service.repository.CouponRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CouponService extends CouponServiceGrpc.CouponServiceImplBase {
    private final CouponRepository couponRepository;

    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    @Override
    public void createCoupon(CreateCouponRequest request, io.grpc.stub.StreamObserver<CreateCouponResponse> responseObserver) {
        try {
            couponRepository.createCoupon(request.getCode(), request.getDiscountPercentage(), request.getExpirationDate(), request.getCreatedBy());
            CreateCouponResponse response = CreateCouponResponse.newBuilder()
                    .setStatus("true")
                    .setMessage("Create coupon successfully")
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            CreateCouponResponse response = CreateCouponResponse.newBuilder()
                    .setStatus("false")
                    .setMessage("Error while creating coupon")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onError(e);
        }
    }

    @Override
    public void updateCoupon(UpdateCouponRequest request, io.grpc.stub.StreamObserver<UpdateCouponResponse> responseObserver) {
        try {
            couponRepository.updateCoupon(request.getId(), request.getCode(), request.getDiscountPercentage(), request.getExpirationDate(), request.getCreatedBy());

            Coupon coupon_updated = Coupon.newBuilder()
                    .setId(request.getId())
                    .setCode(request.getCode())
                    .setDiscountPercentage(request.getDiscountPercentage())
                    .setExpirationDate(request.getExpirationDate())
                    .setCreatedBy(request.getCreatedBy())
                    .build();

            UpdateCouponResponse response = UpdateCouponResponse.newBuilder()
                    .setCoupon(coupon_updated)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            UpdateCouponResponse response = UpdateCouponResponse.newBuilder()
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void deleteCoupon(DeleteCouponRequest request, io.grpc.stub.StreamObserver<DeleteCouponResponse> responseObserver) {
        try {
            couponRepository.deleteCoupon(request.getId());

            DeleteCouponResponse response = DeleteCouponResponse.newBuilder()
                    .setStatus("true")
                    .setMessage("Delete coupon successfully")
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            DeleteCouponResponse response = DeleteCouponResponse.newBuilder()
                    .setStatus("false")
                    .setMessage("Error while deleting coupon")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getCoupon(GetCouponRequest request, io.grpc.stub.StreamObserver<GetCouponResponse> responseObserver) {
        try {
            var coupon = couponRepository.findCouponById(request.getId());
            if (coupon.isEmpty()) {
                GetCouponResponse response = GetCouponResponse.newBuilder()
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
                return;
            }
            Coupon coupon_response = Coupon.newBuilder()
                    .setId((int) coupon.get().get("id"))
                    .setCode(coupon.get().get("code").toString())
                    .setDiscountPercentage(((BigDecimal)coupon.get().get("discount_percentage")).doubleValue())
                    .setExpirationDate(coupon.get().get("expiration_date").toString())
                    .setCreatedBy((int) coupon.get().get("created_by"))
                    .setCreatedAt(coupon.get().get("created_at").toString())
                    .build();
            GetCouponResponse response = GetCouponResponse.newBuilder()
                    .setCoupon(coupon_response)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            responseObserver.onError(e);
        }
    }

    @Override
    public void getAllCoupons(GetAllCouponsRequest request, io.grpc.stub.StreamObserver<GetAllCouponsResponse> responseObserver) {
        try {
            var coupons = couponRepository.findAllCoupons();
            GetAllCouponsResponse.Builder response = GetAllCouponsResponse.newBuilder();
            for (var coupon : coupons) {
                Coupon coupon_response = Coupon.newBuilder()
                        .setId((int) coupon.get("id"))
                        .setCode(coupon.get("code").toString())
                        .setDiscountPercentage(((BigDecimal) coupon.get("discount_percentage")).doubleValue())
                        .setExpirationDate(coupon.get("expiration_date").toString())
                        .setCreatedBy((int) coupon.get("created_by"))
                        .build();
                response.addCoupons(coupon_response);
            }
            responseObserver.onNext(response.build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            responseObserver.onError(e);
        }
    }

    @Override
    public void getCouponByCode(GetCouponByCodeRequest request, io.grpc.stub.StreamObserver<GetCouponByCodeResponse> responseObserver) {
        try {
            var coupon = couponRepository.findCouponByCode(request.getCode());
            if (coupon.isEmpty()) {
                GetCouponByCodeResponse response = GetCouponByCodeResponse.newBuilder()
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
                return;
            }

            Coupon coupon_response = Coupon.newBuilder()
                    .setId((int) coupon.get().get("id"))
                    .setCode(coupon.get().get("code").toString())
                    .setDiscountPercentage(((BigDecimal) coupon.get().get("discount_percentage")).doubleValue())
                    .setExpirationDate(coupon.get().get("expiration_date").toString())
                    .setCreatedBy((int) coupon.get().get("created_by"))
                    .build();
            GetCouponByCodeResponse response = GetCouponByCodeResponse.newBuilder()
                    .setCoupon(coupon_response)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }
}
